class Solution {
    public int maximumStrongPairXor(int[] nums) {
        Tree obj=new Tree();
        Arrays.sort(nums);
        int st=0,max=0;
        for(int i=0;i<nums.length;i++){
while(st<i&&Math.abs(nums[st]-nums[i])>Math.min(nums[st],nums[i])){
    obj.remove(nums[st++]);
}
obj.insert(nums[i]);
max=Math.max(max,obj.max(nums[i]));
        }
        return max;
    }
}
class Node{
    Node a[]=new Node[2];
    int c=0;
}
class Tree{
Node root=new Node();
public void insert(int n){
    Node temp=root;
    for(int i=31;i>=0;i--){
        int x=(n>>i)&1;
        if(temp.a[x]==null)temp.a[x]=new Node();
        temp=temp.a[x];
        temp.c++;
    }
}
public void remove(int n){
    Node temp=root;
    for(int i=31;i>=0;i--){
        int x=(n>>i)&1;
        temp=temp.a[x];
        temp.c--;
    }
}
public int max(int n){
     Node temp=root;
     int res=0;
    for(int i=31;i>=0;i--){
        int x=(n>>i)&1;
        int y=1-x;
        if(temp.a[y]!=null&&temp.a[y].c>0){
            res|=(1<<i);
            temp=temp.a[y];
        }
       else if(temp.a[x]!=null&&temp.a[x].c>0){
            temp=temp.a[x];
        }
       else return res;
    }
    return res;
}

}