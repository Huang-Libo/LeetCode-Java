import java.util.HashSet;

/**
 * 217. 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * https://leetcode-cn.com/problems/contains-duplicate/
 */

public class _217_contains_duplicate {
    public static class Solution {
        public boolean containsDuplicate(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (set.contains(num)) return true;
                set.add(num);
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,1};
        Solution solution = new Solution();
        System.out.println(solution.containsDuplicate(nums));
    }
}
