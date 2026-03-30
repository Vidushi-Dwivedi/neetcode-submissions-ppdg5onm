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
    boolean flag = true;
    public int balanced(TreeNode root){
        if(root == null){ return 0;}

        int left = balanced(root.left);
        int right = balanced(root.right);

        flag = flag && (Math.abs(left-right)<=1)? true : false ;

        return 1 + Math.max(left, right); 
    }
    public boolean isBalanced(TreeNode root) {
        balanced(root);
        return flag;
    }
}
