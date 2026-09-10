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
    private int matchingNodes = 0;

    public int averageOfSubtree(TreeNode root) {
        matchingNodes = 0;
        postOrder(root);
        return matchingNodes;
    }

    // Returns an array of two integers: [subtreeSum, subtreeNodeCount]
    private int[] postOrder(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = postOrder(node.left);
        int[] right = postOrder(node.right);

        int subtreeSum = left[0] + right[0] + node.val;
        int subtreeCount = left[1] + right[1] + 1;

        // Integer division in Java automatically rounds down towards zero
        if (subtreeSum / subtreeCount == node.val) {
            matchingNodes++;
        }

        return new int[]{subtreeSum, subtreeCount};
    }
}