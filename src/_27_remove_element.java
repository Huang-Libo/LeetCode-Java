/**
 * 27. 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * https://leetcode-cn.com/problems/remove-element/
 */

public class _27_remove_element {
    public static class Solution1 {
        public int removeElement(int[] nums, int val) {
            int len = nums.length;
            for (int i = 0, j = len - 1; i < len; i++) {
                if (nums[i] != val) continue;
                while (nums[j] == val && j > i) {
                    j--;
                    len--;
                }
                nums[i] = nums[j--];
                len--;
            }
            return len;
        }
    }

    // 此解法甚巧妙, 详情请看官方题解 https://leetcode-cn.com/problems/remove-element/solution/yi-chu-yuan-su-by-leetcode/
    public static class Solution2 {
        public int removeElement(int[] nums, int val) {
            int i = 0;
            int len = nums.length;
            while (i < len) {
                if (nums[i] == val) {
                    // 请注意，被交换的最后一个元素可能是您想要移除的值。但是不要担心，在下一次迭代中，我们仍然会检查这个元素。
                    nums[i] = nums[len - 1];
                    len--;
                } else {
                    i++;
                }
            }
            return len;
        }
    }

    public static void main(String[] args) {
        // test case
//        int[] nums = new int[]{3,2,2,3};
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;

//        Solution1 solution = new Solution1();
        Solution2 solution = new Solution2();
        int len = solution.removeElement(nums, val);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
