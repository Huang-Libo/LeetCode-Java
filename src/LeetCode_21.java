import DataStructures.ListNode;

/**
 * 21. 合并两个有序链表.
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class LeetCode_21 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 4};
        int[] nums2 = new int[]{1, 3, 4};

        System.out.println("迭代的解法:");
        Solution_1 solution_1 = new Solution_1();
        ListNode.printList(solution_1.mergeTwoLists(ListNode.createList(nums1), ListNode.createList(nums2)));

        System.out.println("递归的解法:");
        Solution_2 solution_2 = new Solution_2();
        ListNode.printList(solution_2.mergeTwoLists(ListNode.createList(nums1), ListNode.createList(nums2)));
    }

    public static class Solution_2 {
        // 方法二：递归
        // 当 l1 或 l2 等于 null 时，“递”结束，“归”开始。
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            if (l1.val <= l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
    }

    public static class Solution_1 {
        // 方法一：迭代
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(-1);
            ListNode prev = dummyHead;
            ListNode p1 = l1, p2 = l2;
            while (p1 != null && p2 != null) {
                if (p1.val <= p2.val) {
                    prev.next = p1;
                    p1 = p1.next;
                } else {
                    prev.next = p2;
                    p2 = p2.next;
                }
                prev = prev.next;
            }
            if (p1 != null) prev.next = p1;
            if (p2 != null) prev.next = p2;
            return dummyHead.next;
        }

        // 未使用 dummyHead，需要在循环内处理特殊逻辑，较繁琐。
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null) return l2;
//        if (l2 == null) return l1;
//        ListNode head = null, prev = null, curr = null;
//        ListNode l1_curr = l1, l2_curr = l2;
//        while (l1_curr != null && l2_curr != null) {
//            if (l1_curr.val <= l2_curr.val) {
//                curr = l1_curr;
//                l1_curr = l1_curr.next;
//            } else {
//                curr = l2_curr;
//                l2_curr = l2_curr.next;
//            }
//            if (head == null) head = curr;
//            if (prev != null) prev.next = curr;
//            prev = curr;
//        }
//        if (l1_curr != null) curr.next = l1_curr;
//        if (l2_curr != null) curr.next = l2_curr;
//        return head;
//    }
    }
}
