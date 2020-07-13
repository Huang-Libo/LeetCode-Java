/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * https://leetcode-cn.com/problems/search-insert-position/
 */
public class _35_search_insert_position {
    public static class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                // 考虑到可能发生的整型溢出, 使用 left + (right - left) / 2 取 mid, 比 (left + right) / 2 更安全一点。
                int mid = left + (right - left) / 2;
                if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            }
            return left;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(nums, 0));
    }
}
