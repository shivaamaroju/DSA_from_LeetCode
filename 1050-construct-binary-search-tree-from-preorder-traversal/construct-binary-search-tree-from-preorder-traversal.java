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
    public TreeNode bstFromPreorder(int[] preorder) {
       TreeNode root=null;
       for(var s: preorder){
        root=pre(root,s);
       } 
       return root;
    }
    public TreeNode pre(TreeNode root,int val){
        if(root==null){
            root=new TreeNode(val);
            return root;
        }
        if(root.val>val){
            root.left=pre(root.left,val);
        }
        else 
           root.right=pre(root.right,val);
           return root;
    }
}