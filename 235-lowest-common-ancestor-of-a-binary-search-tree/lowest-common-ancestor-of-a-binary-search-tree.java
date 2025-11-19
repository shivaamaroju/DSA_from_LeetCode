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
        List<TreeNode> l=new ArrayList<>();
        List<TreeNode> r=new ArrayList<>();
        helper(root,l,p);
        helper(root,r,q);
        int i=0;
        TreeNode ans=null;
        for(i=0;i<Math.min(l.size(),r.size());i++){
            if(l.get(i)==r.get(i))ans=l.get(i);
            else break;
        }
return ans;
    }
    public boolean helper(TreeNode root,List<TreeNode> l,TreeNode find){
        if(root==null)return false;
        l.add(root);
        if(root==find)return true;
        boolean left=helper(root.left,l,find);
        if(left)return true;
        l.remove(l.size()-1);
        l.add(root);
        boolean right=helper(root.right,l,find);
        if(right)return true;
        l.remove(l.size()-1);
        return false;
    }
}