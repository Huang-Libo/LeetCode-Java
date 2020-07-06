import java.util.HashSet;

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
