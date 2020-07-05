/**
 * 198. 打家劫舍
 * 经典的动态规划题, 题干较长, 请打开链接查看.
 * https://leetcode-cn.com/problems/house-robber/
 */

public class _198_house_robber {
    /**
     * 方法一: 动态规划, 用数组来记录偷到第 i 间房的最高累计金额. 空间复杂度 O(n)
     */
    public static class Solution1 {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int n = nums.length;
            if (n == 1) { // 单独处理只有一个元素的情况, 以防数组越界
                return nums[0];
            }
            int[] f = new int[n];
            // 只有一间房的最高金额
            f[0] = nums[0];
            // 有两间房的最高进而
            f[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < n; i++) {
                // 从第三间房开始, 第 i 间房就有两种选择:
                // 1.偷第 i 间房, 则不能偷第 i - 1 间房, 最大累计金额是 nums[i] + f[i-2]
                // 2.不偷第 i 间房, 则最大累计金额是 f[i-1]
                // 从上述两种情况中选取金额更大的那个
                f[i] = Math.max(nums[i] + f[i-2], f[i-1]);
            }
           return f[n-1];
        }
    }

    /**
     * 方法二: 动态规划 + "滚动数组", 将空间复杂度优化为 O(1)
     * 用"滚动数组"记录: 考虑到每间房屋的最高总金额只和该房屋的前两间房屋的最高总金额相关，
     *                因此可以使用滚动数组，在每个时刻只需要存储前两间房屋的最高总金额。
     */
    public static class Solution2 {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int n = nums.length;
            if (n == 1) {
                return nums[0];
            }
            int first = nums[0], second = Math.max(nums[0], nums[1]);
            for (int i = 2; i < n; i++) {
                int tmp = second;
                second = Math.max(nums[i] + first, second);
                first = tmp;
            }
            return second;
        }
    }


    public static void main(String[] args) {
//        int[] nums = new int[]{1,2,3,1};
        int[] nums = new int[]{2,7,9,3,1};
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.rob(nums));

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.rob(nums));
    }
}
