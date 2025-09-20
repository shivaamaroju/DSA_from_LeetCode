class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie obj=new Trie();
        for(var s:nums)obj.insert(s);
        int max=0;
        for(var s:nums)max=Math.max(max,obj.max(s));
        return max;

    }
}
class Node{
    Node a[]=new Node[2];
}
class Trie{
    Node root;
    Trie(){
        root=new Node();
    }
    public void insert(int n){
        Node temp=root;
        for(int i=31;i>=0;i--){
            int x=(n>>i)&1;
            if(temp.a[x]==null){
                temp.a[x]=new Node();
            }
            temp=temp.a[x];
        }
    }
    public int max(int n){
        Node temp=root;
        int res=0;
        for(int i=31;i>=0;i--){
            int x=(n>>i)&1;
            int op=1-x;
            if(temp.a[op]!=null){
                res|=(1<<i);
                temp=temp.a[op];
            }
            else if(temp.a[x]!=null){
                temp=temp.a[x];
            }
            else return res;
        }
        return res;
    }
}