import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;
import MyDataStructures.TreeNode;

/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class LeetCode_102_binary_tree_level_order_traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            ArrayList<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(levelList);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode_102_binary_tree_level_order_traversal leetCode_102_binary_tree_level_order_traversal =
                new LeetCode_102_binary_tree_level_order_traversal();

        // test case
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(11);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        leetCode_102_binary_tree_level_order_traversal.levelOrder(root);
        // case: 传入 null
//        leetCode_102_binary_tree_level_order_traversal.levelOrder(null);
    }
}
