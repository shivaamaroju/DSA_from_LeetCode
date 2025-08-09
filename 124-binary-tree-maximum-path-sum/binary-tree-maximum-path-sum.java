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
    public int maxPathSum(TreeNode root) {
        int a[]=new int[1];
        a[0]=Integer.MIN_VALUE;
        helper(root,a);
        return a[0];
    }
    public int helper(TreeNode root,int a[]){
        if(root==null)return 0;
        int left=Math.max(0,helper(root.left,a));
        int right=Math.max(0,helper(root.right,a));
        a[0]=Math.max(a[0],(root.val+left+right));
        return root.val+Math.max(left,right);
    }
}