import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * https://leetcode-cn.com/problems/single-number/
 */

public class _136_single_number {
    /**
     * 方法一: 使用 HashMap 记录每个元素出现的次数. (需要遍历两次)
     */
    public static class Solution1 {
        public int singleNumber(int[] nums) {
            int result = 0;
            HashMap<Integer, Integer> map = new HashMap();
            for (int num : nums) {
                if (!map.containsKey(num)) {
                    map.put(num, 1);
                } else {
                    map.put(num, (int)map.get(num) + 1);
                }
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    result = entry.getKey();
                }
            }
            return result;
        }
    }

    /**
     * 方法二: 使用 HashSet, 如果有相同的元素就从集合中删掉. 最后剩下的数就是只出现一次的数. (类似抽乌龟)
     */
    public static class Solution2 {
        public int singleNumber(int[] nums) {
            int result = 0;
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (!set.contains(num)) {
                    set.add(num);
                } else {
                    set.remove(num);
                }
            }
            for (int num : set) { // 由于 set 中只剩一个数了, 循环只会执行一次.
                result = num;
            }
            return result;
        }
    }

    /**
     * 方法三: 使用异或. 不需要额外的空间, 一次遍历即可得到结果.
     * 异或的性质:
     *  1. a ^ 0 = a
     *  2. a ^ a = 0
     *  3. a ^ b ^ a = (a ^ a) ^ b [说明: 异或遵守"交换律"和"结合律"]
     */
    public static class Solution3 {
        public int singleNumber(int[] nums) {
            int result = 0;
            for (int num : nums) {
                result ^= num;
            }
            return result;
        }
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{2,2,1};
        int[] nums = new int[]{4,1,2,1,2};

        Solution1 solution1 = new Solution1();
        System.out.println(solution1.singleNumber(nums));

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.singleNumber(nums));

        Solution3 solution3 = new Solution3();
        System.out.println(solution3.singleNumber(nums));
    }
}
