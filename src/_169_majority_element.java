import java.util.HashMap;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 n/2 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * https://leetcode-cn.com/problems/majority-element/
 */

public class _169_majority_element {
    public static class Solution {
        public int majorityElement(int[] nums) {
            // 需要找的数
            int res = 0;
            // 当前出现过的最大次数. 维护这个变量, 可以在录入完成后就得出结果.
            int maxCount = 0;
            // 使用 HashMap 记录出现数字的次数. key 是数字, value 是数字出现的次数.
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                int currentCount = 0;
                if (!map.containsKey(num)) {
                    currentCount = 1;
                } else {
                    currentCount = (int)map.get(num) + 1;
                }
                map.put(num, currentCount);
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    res = num;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(nums));
    }
}
