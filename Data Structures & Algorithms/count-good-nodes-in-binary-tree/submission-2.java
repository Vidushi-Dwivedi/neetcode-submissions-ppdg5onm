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
    int count = 0;
    public void count(TreeNode root, int max){
        if(root == null){ return;}

        max = Math.max(max, root.val);
        count = count + ((max <= root.val)? 1 : 0);

        count(root.left, max);
        count(root.right, max);

        return;
    }
    public int goodNodes(TreeNode root) {
        count(root, -101);
        return count;
    }
}
