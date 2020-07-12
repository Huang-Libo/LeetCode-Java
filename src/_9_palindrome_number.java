/**
 * 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * https://leetcode-cn.com/problems/palindrome-number/
 */
public class _9_palindrome_number {
    public static void main(String[] args) {
        int num = 120;

        Solution1 solution1 = new Solution1();
        System.out.println(solution1.isPalindrome(num));

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.isPalindrome(num));
    }

    // 方法二: 未使用额外的数组或字符串.
    // 参考官方题解: https://leetcode-cn.com/problems/palindrome-number/solution/hui-wen-shu-by-leetcode-solution/
    static class Solution2 {
        public boolean isPalindrome(int x) {
            // 尾数为 0 时, 对 10 取模总为 0, 无法使用后续的逻辑. 这里直接判定为非回文数.
            if (x < 0 || (x != 0 && x % 10 == 0)) return false;
            int revertedNumber = 0;
            while (x > revertedNumber) {
                revertedNumber = revertedNumber * 10 + x % 10;
                x = x / 10;
            }
            // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
            // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
            // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
            return x == revertedNumber || x == revertedNumber / 10;
        }
    }

    // 方法一: 使用了额外的 int 数组. 其实和转换成字符串的做法差不多.
    static class Solution1 {
        public boolean isPalindrome(int x) {
            if (x < 0) return false;
            int[] nums = new int[10];
            int length = 0;
            while (x > 0) {
                nums[length++] = x % 10;
                x = x / 10;
            }
            int i = 0, j = length - 1;
            while (i < j) {
                if (nums[i++] != nums[j--]) {
                    return false;
                }
            }
            return true;
        }
    }
}
