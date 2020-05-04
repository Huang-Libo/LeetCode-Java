package DataStructures;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) { val = x; }

    /**
     * 通过 int 数组创建一个 List。
     * @param nums int 数组
     * @return 一个 ListNode 实例，即该 List 的头结点
     */
    public static ListNode createList(int[] nums) {
        ListNode head = null, prev = null;
        for (int i = 0; i < nums.length; i++) {
            ListNode curr = new ListNode(nums[i]);
            if (i == 0) head = curr;
            if (prev != null) {
                prev.next = curr;
            }
            prev = curr;
        }

        return head;
    }

    /**
     * 打印一个 List 中的所有元素。
     * @param list 该 list 的头结点
     */
    public static void printList(ListNode list) {
        System.out.println("print list:");
        ListNode current = list;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
}


