class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        SEG obj=new SEG(baskets);
        int c=0;
        for(int s:fruits){
            int pos=obj.query(0,0,baskets.length-1,s);
            if(pos!=-1){
                obj.update(0,0,baskets.length-1,pos,0);

            }
            else c++;

        }
        return c;
    }
}
class SEG{
    int n,seg[];
    SEG(int nums[]){
        n=nums.length;
        seg=new int[4*n];
        build(0,0,n-1,nums);
    }
    public void build(int idx,int l,int h,int nums[]){
        if(l==h){
            seg[idx]=nums[l];
            return;
        }
        int mid=(l+h)/2;
        build(2*idx+1,l,mid,nums);
        build(2*idx+2,mid+1,h,nums);
        seg[idx]=Math.max(seg[2*idx+1],seg[2*idx+2]);
    }
    public int query(int idx,int l,int h,int pos){
        if(seg[idx]<pos)return -1;
        if(l==h)return l;
        int mid =(l+h)/2;
       int left= query(2*idx+1,l,mid,pos);
       if(left!=-1)return left;
    return query(2*idx+2,mid+1,h,pos);
    }
    public void update(int idx,int l,int h,int pos,int val){
        if(l==h){
            seg[idx]=0;
            return;
        }
        int mid=(l+h)/2;
        if(pos<=mid)update(2*idx+1,l,mid,pos,val);
        else update(2*idx+2,mid+1,h,pos,val);
        seg[idx]=Math.max(seg[2*idx+1],seg[2*idx+2]);
    }
}