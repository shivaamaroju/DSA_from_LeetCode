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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null)return false;
        if(root==subRoot)return true;
       if(issame(root,subRoot))return true;
        return isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);
    }
    public boolean issame(TreeNode root,TreeNode sub){
        if(root==null&&sub==null)return true;
        if(root==null||sub==null)return false;
        if(root.val==sub.val)return issame(root.left,sub.left)&&issame(root.right,sub.right);
        return false;

    }
}