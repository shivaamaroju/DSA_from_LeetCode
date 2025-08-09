/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return null;
        ArrayList<TreeNode> l=new ArrayList<>();
        ArrayList<TreeNode> l2=new ArrayList<>();
        l.add(root);
        l2.add(root);
        helper(root,p,l);
        helper(root,q,l2);
        TreeNode c=null;
        for(int i=0;i<Math.min(l.size(),l2.size());i++){
            if(l.get(i)==l2.get(i))c=l.get(i);
            else break;
        }
        return c;
    }
    public boolean helper(TreeNode root,TreeNode p,ArrayList<TreeNode> l){
        if(root==null)return false;
        if(root==p)return true;
        if(root.left!=null){
            l.add(root.left);
            boolean x=helper(root.left,p,l);
            if(x)return true;
            l.remove(l.size()-1);
        }
        if(root.right!=null){
            l.add(root.right);
            boolean x=helper(root.right,p,l);
            if(x)return true;
            l.remove(l.size()-1);
        }
        return false;
        }

    
}