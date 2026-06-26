/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) {
 *         data = val;
 *         left = null;
 *         right = null;
 *     }
 * }
 **/

class Solution {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    public int helper(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        int candidate = left + right + root.val;
        maxSum = Math.max(maxSum, candidate);
        return root.val + Math.max(left, right);
    }
}