/**
 * 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * https://leetcode-cn.com/problems/palindrome-number/
 */
public class LeetCode_9_palindrome_number {
    public static void main(String[] args) {
        int num = 120;

        Solution_1 solution_1 = new Solution_1();
        System.out.println(solution_1.isPalindrome(num));

        Solution_2 solution_2 = new Solution_2();
        System.out.println(solution_2.isPalindrome(num));
    }

    // 方法二: 未使用额外的数组或字符串.
    // 参考官方题解: https://leetcode-cn.com/problems/palindrome-number/solution/hui-wen-shu-by-leetcode/
    static class Solution_2 {
        public boolean isPalindrome(int x) {
            // 这里使用 x != 0 比 x > 0 效率高
            if (x < 0 || (x != 0 && x % 10 == 0)) return false;
            int rev = 0;
            while (x > rev) {
                rev = rev * 10 + x % 10;
                x = x / 10;
            }
            return x == rev || x == rev / 10;
        }
    }

    // 方法一: 使用了额外的 int 数组. 其实和转换成字符串的做法差不多.
    static class Solution_1 {
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
