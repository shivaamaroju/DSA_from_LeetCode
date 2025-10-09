/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String s="";
        if(root==null)return "null";
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            TreeNode x=q.remove();
            if(x!=null)s+=x.val+",";
            else s+="null,";
            if(x==null)continue;
            if(x!=null){
                q.add(x.left);q.add(x.right);}
        }
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null||data.length()==0)return null;
        String A[]=data.split(",");
        if(A[0].equals("null"))return null;
        TreeNode root=new TreeNode(Integer.parseInt(A[0]));
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int j=1;
        while(q.size()>0){
            TreeNode x=q.remove();
           
if(j<A.length&&!A[j].equals("null")){
    x.left=new TreeNode(Integer.parseInt(A[j]));
    q.add(x.left);}
    j++;
if(j<A.length&&!A[j].equals("null")){
    x.right=new TreeNode(Integer.parseInt(A[j]));
    q.add(x.right);}
    j++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));