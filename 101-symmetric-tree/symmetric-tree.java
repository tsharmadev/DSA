/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        //your code goes here
        TreeNode node1=root.left;
        TreeNode node2=root.right;
        return helper(node1,node2);

    }
    public boolean helper(TreeNode node1,TreeNode node2){
        if(node1==null && node2==null){
            return true;
        }
        if(((node1==null)&&(node2!=null))||((node1!=null)&&(node2==null))){
            return false;
        }
        if(node1.val!=node2.val){
            return false;
        }
        return ((helper(node1.left,node2.right))&&(helper(node1.right,node2.left)));
    }
}