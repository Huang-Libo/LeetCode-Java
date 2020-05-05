import DataStructures.ListNode;

public class LeetCode_141 {
    public static void main(String[] args) {
        LeetCode_141 leetCode_141 = new LeetCode_141();

        // 创建一个环形链表的测试用例
        int[] nums = new int[]{1};
        ListNode cycleList = ListNode.createCycleList(nums, 0);
//        ListNode.printList(cycleList);
        System.out.println(leetCode_141.hasCycle(cycleList));
    }

    // 解法一：快慢指针。一定要注意判断 null，避免出现 NullPointerException 错误。
    /* 快慢指针解法的原理：
    考虑下面这种情况（记作情况 A）- 假如快跑者只落后慢跑者一步，在下一次迭代中，它们就会分别跑了一步或两步并相遇。
    其他情况又会怎样呢？例如，我们没有考虑快跑者在慢跑者之后两步或三步的情况。但其实不难想到，因为在下一次或者下下次迭代后，又会变成上面提到的情况 A。
    */
    // 解法二：使用 HashSet 记录遍历到的每个节点，如果遇到了重复的，则说明有环。缺点是需要额外的空间。
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
