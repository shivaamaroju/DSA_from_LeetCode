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
    List<Integer> l=new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        helper(root);
        Collections.sort(l);
        int min=-1;
        for(int i=0;i<k;i++){
            min=l.get(i);
        }
        return min;
    }
    public void helper(TreeNode x){
        if(x==null)return;
        l.add(x.val);
        helper(x.left);
        helper(x.right);


    }
}