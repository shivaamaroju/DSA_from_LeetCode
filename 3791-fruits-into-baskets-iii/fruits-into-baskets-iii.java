class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        Tree obj=new Tree(baskets.length,baskets);
        int c=0;
        for(var s: fruits){
int idx=obj.place(s);
if(idx==-1)c++;
        }
        return c;
    }
}
class Tree{
    int n;
    int seg[];
    public Tree(int n,int a[]){
        this.n=n;
    seg=new int[4*n];
build(0,0,n-1,a);
// for(var s:seg){
//     System.out.print(s+" ");
// }
    }
    public void build(int idx,int l,int h,int a[]){
        if(l==h){
            seg[idx]=a[l];
            return;
        }
        int mid=(l+h)/2;
        build(2*idx+1,l,mid,a);
        build(2*idx+2,mid+1,h,a);
        seg[idx]=Math.max(seg[2*idx+1],seg[2*idx+2]);
    }
    public int place(int val){
        int x=helper(0,0,n-1,val);
        if(x!=-1){
           update(0,0,n-1,x);
           return x;
        }
        return x;
    }
    public int helper(int idx,int l,int h,int val){
        if(seg[idx]<val)return -1;
        if(l==h){
            return l;
        }
        int mid=(l+h)/2;
        int left=helper(2*idx+1,l,mid,val);
        if(left!=-1)return left;
        int right=helper(2*idx+2,mid+1,h,val);
        return right;
    }
    public void update(int idx,int l,int h,int pos){
        if(l==h){
            seg[idx]=0;
            return;
        }
        int mid=(l+h)/2;
        if(pos<=mid)update(2*idx+1,l,mid,pos);
        else update(2*idx+2,mid+1,h,pos);
        seg[idx]=Math.max(seg[2*idx+1],seg[2*idx+2]);
    }
}