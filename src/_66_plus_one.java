/**
 * 66. 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * https://leetcode-cn.com/problems/plus-one/
 */

public class _66_plus_one {
    // 巧妙的方法
    public static class Solution_good {
        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >= 0 ; i--) {
                digits[i]++;
                if (digits[i] % 10 != 0) return digits;
                digits[i] = 0;
            }
            digits = new int[digits.length + 1];
            digits[0] = 1; // 后面的元素默认值为 0, 所以不需处理
            return digits;
        }
    }

    // 笨拙的方法...
    public static class Solution_bad {
        public int[] plusOne(int[] digits) {
            int n = digits.length;
            int carry = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (i == n - 1) {
                    if (digits[i] < 9) {
                        digits[i] = digits[i] + 1;
                        return digits;
                    } else {
                        carry = 1;
                        digits[i] = 0;
                    }
                } else {
                    if (carry == 0) {
                        return digits;
                    } else {
                        if (digits[i] < 9) {
                            digits[i] = digits[i] + carry;
                            carry = 0;
                            return digits;
                        } else {
                            carry = 1;
                            digits[i] = 0;
                        }
                    }
                }
            }
            if (carry == 1) {
                int[] newDigits = new int[n+1];
                newDigits[0] = 1;
                for (int i = 0; i < n; i++) {
                    newDigits[i+1] = digits[i];
                }
                return newDigits;
            } else {
                return digits;
            }
        }
    }

    public static void main(String[] args) {
        int[] digits = new int[]{9,9,9};
        // bad
//        Solution_bad solutionBad = new Solution_bad();
//        int[] handledDigits = solutionBad.plusOne(digits);

        // good
        Solution_good solution_good = new Solution_good();
        int[] handledDigits = solution_good.plusOne(digits);

        // 打印结果
        int res = 0;
        for (int num : handledDigits) {
            res = res * 10 + num;
        }
        System.out.println(res);
    }
}
