class Solution {
    public int maximumStrongPairXor(int[] nums) {
        Trie obj=new Trie();
        int st=0;
        Arrays.sort(nums);
        int max=0;
        for(int i=0;i<nums.length;i++){
            obj.insert(nums[i]);
            while(st<i&&Math.abs(nums[st]-nums[i])>Math.min(nums[i],nums[st])){
                obj.remove(nums[st++]);
            }
            max=Math.max(max,obj.maxor(nums[i]));
        }
        return max;
    }
}
class Node{
    Node a[]=new Node[2];
    int c=0;
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
    public int maxor(int n){
        Node temp=root;
        int res=0;
        for(int i=31;i>=0;i--){
            int x=(n>>i)&1;
           int op=1-x;
           if(temp.a[op]!=null&&temp.a[op].c>0){
            res |=(1<<i);
            temp=temp.a[op];
           }
          else  if(temp.a[x]!=null&&temp.a[x].c>0){
            // res |=(1<<i);
            temp=temp.a[x];
           }
           else return res;
        }
        return res;

    }

}