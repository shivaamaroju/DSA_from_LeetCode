class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie obj=new Trie();
        for(int i=0;i<nums.length;i++){
            obj.build(nums[i]);
        }
        int max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,obj.find(nums[i]));
        }
        return max;
    }
}
class Node{
    Node a[]=new Node[2];
    boolean ew=true;
}
class Trie{
    Node root=new Node();
    public void build(int n){
        Node temp=root;
        for(int i=31;i>=0;i--){
            int x=(n>>i)&1;
            if(temp.a[x]==null){
                temp.a[x]=new Node();
            }
            temp=temp.a[x];
        }
        temp.ew=true;
    }
    public int find(int n){
        Node temp=root;
        int xr=0;
        for(int i=31;i>=0;i--){
            int x=(n>>i)&1;
            int op=1-x;
            if(temp.a[op]!=null){
xr|=(1<<i);
temp=temp.a[op];
            }
            else if(temp.a[x]!=null){
               temp= temp.a[x];
            }
            else return xr;
        }
        return xr;
    }
}