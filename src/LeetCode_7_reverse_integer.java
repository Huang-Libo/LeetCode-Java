/**
 * 7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * https://leetcode-cn.com/problems/reverse-integer/
 */
public class LeetCode_7_reverse_integer {
    public static void main(String[] args) {
        LeetCode_7_reverse_integer leetCode_7_reverse_integer = new LeetCode_7_reverse_integer();
        System.out.println(leetCode_7_reverse_integer.reverse(123));
    }

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int pop = x % 10;
            // 本题的关键在于如何提前预知溢出
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE && pop < Integer.MIN_VALUE % 10)) return 0;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE && pop > Integer.MIN_VALUE % 10)) return 0;
            res = res * 10 + pop;
            x = x / 10;
        }
        return res;
    }
}
