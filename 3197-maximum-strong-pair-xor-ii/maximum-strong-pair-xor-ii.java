class Solution {
    public int maximumStrongPairXor(int[] nums) {
    Arrays.sort(nums);
    int st=0;
    trie obj=new trie();
int maxor=0;
    for(int i=0;i<nums.length;i++){
        while(st<i&&Math.abs(nums[i]-nums[st])>Math.min(nums[st],nums[i])){
            obj.remove(nums[st++]);
        }
        obj.insert(nums[i]);
        maxor=Math.max(maxor,obj.maxor(nums[i]));
    }
    return maxor;
    }
}
class Node{
    Node a[]=new Node[2];
    int c=0;
}
class trie{
    Node root;
    trie(){
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
        temp.c++;
    }
    }
    public void remove(int n){
           Node temp=root;
    for(int i=31;i>=0;i--){
        int x=(n>>i)&1;
        if(temp.a[x]==null){
            temp.a[x]=new Node();
        }
        temp=temp.a[x];
        temp.c--;
    }

    }
    public int maxor(int n){
           Node temp=root;
           int res=0;
    for(int i=31;i>=0;i--){
        int x=(n>>i)&1;
        int y=1-x;
        if(temp.a[y]!=null&&temp.a[y].c>0){
        res|=(1<<i);
        temp=temp.a[y];
        }
        else if(temp.a[x]!=null&&temp.a[x].c>0)
        temp=temp.a[x];
        else return res;
      
    }
    return res;
    }
}