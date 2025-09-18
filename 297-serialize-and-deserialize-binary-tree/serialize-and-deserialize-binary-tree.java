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
        if(root==null)return "";
        StringBuilder s=new StringBuilder();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            TreeNode x=q.poll();
            if(x==null){
                s.append("null,");
                continue;
            }
            s.append(x.val).append(",");
            q.add(x.left);
            q.add(x.right);
        }
        
        return s.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String s) {
       if(s==null || s.length()==0)return null;
       String v[]=s.split(",");
       if(v[0].equals("null") || v[0].isEmpty())return null;
       TreeNode root=new TreeNode(Integer.parseInt(v[0]));
       Queue<TreeNode> q=new LinkedList<>();
       q.add(root);
       int i=1;
       while(!q.isEmpty()){
        TreeNode y=q.remove();
if(i<v.length&&!v[i].equals("null")){
    y.left=new TreeNode(Integer.parseInt(v[i]));
    q.add(y.left);

}
i++;
if(i<v.length&&!v[i].equals("null")){
    y.right=new TreeNode(Integer.parseInt(v[i]));
    q.add(y.right);

}
i++;
       }
       return root;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));