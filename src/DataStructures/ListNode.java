package DataStructures;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) { val = x; }

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

    public static void printList(ListNode list) {
        System.out.println("print list:");
        ListNode current = list;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
}


