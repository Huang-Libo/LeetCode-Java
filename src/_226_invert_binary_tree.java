import MyDataStructures.TreeNode;

/**
 * 226. 翻转二叉树
 * 示例：
 * 输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */

public class _226_invert_binary_tree {
    public static class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            helper(root);
            return root;
        }

        public void helper(TreeNode treeNode) {
            TreeNode tmp = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = tmp;
            if (treeNode.left != null) {
                helper(treeNode.left);
            }
            if (treeNode.right != null) {
                helper(treeNode.right);
            }
        }
    }

    public static void main(String[] args) {
        // 根节点
        TreeNode root = new TreeNode(4);
        // 第二层
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        // 第三层
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        Solution solution = new Solution();
//        solution.invertTree(null);
        solution.invertTree(root);
    }
}
