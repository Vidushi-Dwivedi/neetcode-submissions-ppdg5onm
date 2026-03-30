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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();

        if(root == null){ return ans;}

        que.offer(root);

        while(!que.isEmpty()){
            int size = que.size();
            TreeNode temp = null;

            while(size > 0){
                temp = que.poll();
                if(temp.left != null){ que.offer(temp.left);}
                if(temp.right != null) { que.offer(temp.right);}

                size--;
            }

            ans.add(temp.val);
        }

        return ans;
    }
}
