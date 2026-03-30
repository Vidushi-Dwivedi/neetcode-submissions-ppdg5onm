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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();

        if(root == null){ return ans;}

        que.offer(root);

        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> lst = new ArrayList<>();

            while(size > 0){
                TreeNode cur = que.poll();
                if(cur.left != null){ que.offer(cur.left);}
                if(cur.right != null){ que.offer(cur.right);}
                lst.add(cur.val);
                size--;
            }

            ans.add(lst);
        }

        return ans;

    }
}
