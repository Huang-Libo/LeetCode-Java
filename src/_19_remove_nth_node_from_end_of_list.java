import MyDataStructures.ListNode;

/**
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class _19_remove_nth_node_from_end_of_list {
    public static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null) {
                return null;
            }
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode p1 = dummyHead;
            ListNode p2 = dummyHead;
            // 先将第一个指针往前移动 n
            for (int i = 0; i < n; i++) {
                p1 = p1.next;
            }
            // 两个指针一起移动, 保持固定的间隔
            while (p1.next != null) {
                p1 = p1.next;
                p2 = p2.next;
            }
            p2.next = p2.next.next;
            return dummyHead.next;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // test case
        int[] nums = new int[]{1,2,3,4,5};
        int n = 2;
        ListNode list = ListNode.createList(nums);
        solution.removeNthFromEnd(null,n);
    }
}
