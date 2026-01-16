/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int diameter = -1;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        
        int leftSubtreeHeight = dfs(root.left);
        int rightSubtreeHeight = dfs(root.right);
        diameter = Math.max(diameter, leftSubtreeHeight + rightSubtreeHeight);

        return 1 + Math.max(dfs(root.left), dfs(root.right));
    }
}
