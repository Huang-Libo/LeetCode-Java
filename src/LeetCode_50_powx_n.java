/**
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 说明:
 *   -100.0 < x < 100.0
 *   n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
 *
 * https://leetcode-cn.com/problems/powx-n/
 */
public class LeetCode_50_powx_n {
    public static void main(String[] args) {
        double x = 2.0;
        int n = -10;

//        double x = 1.0;
//        int n = 2147483647;
        // 超时示例, x = 1.0 , n = 2147483647
        Solution_1 solution_1 = new Solution_1();
//        System.out.println(solution_1.myPow(x, n));

        Solution_2 solution_2 = new Solution_2();
        System.out.println(solution_2.myPow(x, n));
    }

//    // 解法三: 二进制
//    static class Solution_3 {
//        public double myPow(double x, int n) {
//
//        }
//    }

    // 解法二: 递归
    static class Solution_2 {
        public double myPow(double x, int n) {
            long N = n; // 这里使用 long, 是为了 myPow 传入防止 -2147483648 导致的溢出
            return (N > 0) ? quiMul(x, N) : 1 / quiMul(x, -N);
        }

        private double quiMul(double x, long N) {
            if (N == 0) return 1.0;
            double y = quiMul(x, N / 2);
            return (N % 2 == 0) ? y * y : y * y * x;
        }
    }

    static class Solution_1 {
        // 这个解法会超时, 比如: x = 1.0 , n = 2147483647
        public double myPow(double x, int n) {
            if (n == 0) return 1.0;
            double res = 1.0;
            for (int i = 0; i < Math.abs(n); i++) {
                res = res * x;
            }
            if (n > 0) {
                return res;
            } else {
                return 1 / res;
            }
        }
    }
}
