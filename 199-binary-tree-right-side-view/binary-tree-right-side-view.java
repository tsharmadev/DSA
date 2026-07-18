import java.util.*;

class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (level == ans.size()) {
                    ans.add(curr.val);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
                if (curr.left != null) {
                    q.offer(curr.left);
                }
            }
            level++;
        }
        return ans;
    }
}