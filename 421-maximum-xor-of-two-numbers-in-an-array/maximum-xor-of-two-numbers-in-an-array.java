class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie obj=new Trie();
        for(var s:nums){
            obj.insert(s);
        }
        int maxor=0;
        for(var s:nums){
maxor=Math.max(maxor,obj.maxors(s));
        }
        return maxor;
    }
}
class Node{
    Node a[]=new Node[2];

}
class Trie{
    Node root=new Node();
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
    public int maxors(int n){
        int maxor=0;
        Node temp=root;
        for(int i=31;i>=0;i--){
            int x=(n>>i)&1;
            int y=1-x;
            if(temp.a[y]!=null){
                maxor|=(1<<i);
temp=temp.a[y];
            }
            else if(temp.a[x]!=null)temp=temp.a[x];
            else return maxor;
        }
        return maxor;
    }
}