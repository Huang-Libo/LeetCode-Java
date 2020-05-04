import DataStructures.ListNode;

/**
 * 21. 合并两个有序链表.
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class LeetCode_21 {
    public static void main(String[] args) {
        LeetCode_21 leetCode_21 = new LeetCode_21();
        ListNode l1 = ListNode.createList(new int[]{1, 2, 4});
        ListNode l2 = ListNode.createList(new int[]{1, 3, 4});
        ListNode mergedList = leetCode_21.mergeTwoLists(l1, l2);
        ListNode.printList(mergedList);
    }

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
