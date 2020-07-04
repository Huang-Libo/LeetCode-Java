/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * https://leetcode-cn.com/problems/maximum-subarray/
 */

public class _53_maximum_subarray {
    /**
     * 思路: 将 nums[i] 与之前的"序列和"相加, 如果大于 numbs[i], 则保留此结果; 如果小于 numb[i], 则更新当前"序列和"为 nums[i].
     *      每轮操作完成后, 将当前"序列和"与 maxSum 做比较, 保留更大值. 一次循环完成后, 就能获取到最大和.
     */
    public static class Solution {
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int currentSum = 0;
            int maxSum = nums[0];
            for (int num : nums) {
                currentSum = Math.max(currentSum + num, num);
                maxSum = Math.max(maxSum, currentSum);
            }
            return maxSum;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
//        int[] nums = new int[]{-1,-2,-3,-4};
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(nums));
    }
}
