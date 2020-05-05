import DataStructures.ListNode;
import java.util.HashSet;
import java.util.Set;

/**
 * 142. 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class LeetCode_142 {
    public static void main(String[] args) {
        LeetCode_142 leetCode_142 = new LeetCode_142();

        // 创建一个环形链表的测试用例
        int[] nums = new int[]{1, 2};
        ListNode cycleList = ListNode.createCycleList(nums, 0);
        ListNode resultNode = leetCode_142.detectCycle(cycleList);
        if (resultNode == null) {
            System.out.println("null");
        } else {
            System.out.println(resultNode.val);
        }
    }

    /*
    解法一：使用 HashSet 判断某节点是否已存储过。需要额外的存储空间。
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> knownNodes = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            if (knownNodes.contains(p)) {
                break;
            }
            knownNodes.add(p);
            p = p.next;
        }
        return p;
    }

    /*
    解法二：分为两阶段。先找到相遇的点；再去找环的入口。
    https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode/
    以及，官方解答也不严谨，网友“mua”的补充很严谨：

    2(F + a) = F + a + b + a

    如果写成以下会更严谨一点

    2(F + a) = F + N(a + b) + a
     2F + 2a = F + 2a + b + (N - 1)(a + b)
           F = b + (N - 1)(a + b)

    F是到达入口点长度
    N为ptr2跑第几圈会与ptr1相遇

    当 F 很大，而圈（a+b）很小的情况下，快指针肯定会绕圈。
     */
}
