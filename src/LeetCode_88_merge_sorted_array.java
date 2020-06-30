/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */

public class LeetCode_88_merge_sorted_array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m + n - 1, p1 = m -1, p2 = n -1;
        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = (nums1[p1] > nums2[p2]) ? nums1[p1--] : nums2[p2--];
        }
        while (p2 >= 0) {
            nums1[p--] = nums2[p2--];
        }
    }

    public static void main(String[] args) {
        LeetCode_88_merge_sorted_array leetCode_88_merge_sorted_array = new LeetCode_88_merge_sorted_array();
        // test case 1
//        int[] nums1 = new int[]{1,2,3,0,0,0};
//        int m = 3;
//        int[] nums2 = new int[]{2,5,6};
//        int n = 3;

        // test case 2
        int[] nums1 = new int[]{0};
        int m = 0;
        int[] nums2 = new int[]{1};
        int n = 1;

        leetCode_88_merge_sorted_array.merge(nums1,m,nums2,n);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }
}
