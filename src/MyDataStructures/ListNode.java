package MyDataStructures;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) { val = x; }

    /**
     * 通过 int 数组创建一个 List。
     * @param nums int 数组
     * @return 一个 ListNode 实例，即该 List 的头结点
     */
    public static ListNode createList(int[] nums) {
        ListNode dummyHead = new ListNode(-1);
        ListNode prev = dummyHead;
        for (int i = 0; i < nums.length; i++) {
            ListNode curr = new ListNode(nums[i]);
            prev.next = curr;
            prev = curr;
        }

        return dummyHead.next;
    }

    // 如果未在 createList 内使用 dummyHead，则需要在 for 循环内的处理特殊逻辑，较繁琐
//    public static ListNode createList(int[] nums) {
//        ListNode head = null, prev = null;
//        for (int i = 0; i < nums.length; i++) {
//            ListNode curr = new ListNode(nums[i]);
//            if (i == 0) head = curr;
//            if (prev != null) {
//                prev.next = curr;
//            }
//            prev = curr;
//        }
//
//        return head;
//    }

    /**
     * 创建环形链表。
     * @param nums 链表的元素
     * @param pos 链表开始入环的第一个节点
     * @return 链表的头指针
     */
    public static ListNode createCycleList(int[] nums, int pos) {
        if (pos < -1) { // 非法值
            return null;
        } else if (pos == -1) { // -1 代表链表中没有环
            return ListNode.createList(nums);
        } else  { // 创建含有环的链表
            ListNode dummyHead = new ListNode(-1);
            ListNode prev = dummyHead;
            ListNode cycleOriginNode = null; // 链表开始入环的第一个节点
            for (int i = 0; i < nums.length; i++) {
                ListNode curr = new ListNode(nums[i]);
                if (i == pos) cycleOriginNode = curr;
                prev.next = curr;
                prev = curr;
            }
            prev.next = cycleOriginNode;

            return dummyHead.next;
        }
    }

    /**
     * 打印一个 List 中的所有元素。
     * @param list 该 list 的头结点
     */
    public static void printList(ListNode list) {
        System.out.println("print list:");
        ListNode current = list;
        int maxCount = 0;
        // 最多打印 20 个节点（我们的自建测试用例基本上在这个范围内）， 避免循环链表导致的死循环
        while (current != null && maxCount < 20) {
            System.out.println(current.val);
            current = current.next;
            maxCount++;
        }
    }
}


