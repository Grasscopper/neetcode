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
    int maxDiameter = -1;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        maxDepth(root);
        return maxDiameter;
    }

    public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);
    maxDiameter = Math.max(maxDiameter, left + right);

    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
