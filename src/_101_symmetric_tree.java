import MyDataStructures.TreeNode;

/**
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * https://leetcode-cn.com/problems/symmetric-tree/
 */

public class _101_symmetric_tree {
    public static class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return check(root.left, root.right);
        }

        /**
         * 使用两个指针, 分别递归遍历左右子树.
         */
        public boolean check(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
        }
    }

    public static void main(String[] args) {
//        Integer[] array = new Integer[]{1,2,2,3,4,4,3};
        Integer[] array = new Integer[]{1,2,2,null,3,null,3};
        TreeNode root = TreeNode.createTreeFromArray(array);

        Solution solution = new Solution();
        System.out.println(solution.isSymmetric(root));
    }
}
