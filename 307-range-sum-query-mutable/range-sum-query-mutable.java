class NumArray {
sum obj;
int n;
    public NumArray(int[] nums) {
      n=nums.length;
        obj=new sum(nums.length);
        obj.build(nums,0,nums.length-1,0);
    }
    
    public void update(int index, int val) {
        obj.update(obj.seg,0,n-1,index,val,0);
    }
    
    public int sumRange(int left, int right) {
        return obj.get(obj.seg,0,n-1,left,right,0);
    }
}
class sum{
    int seg[];
    sum(int n){
        seg=new int[4*n];
    }
public void build(int nums[],int l,int h,int idx){
    if(l==h){
        seg[idx]=nums[l];
        return;
    }
    int mid=(l+h)/2;
    build(nums,l,mid,2*idx+1);
    build(nums,mid+1,h,2*idx+2);
    seg[idx]=seg[2*idx+1]+seg[2*idx+2];
}
public void update(int nums[],int l,int h,int pos,int val,int idx){
    if(l==h){
        seg[idx]=val;
        return;
    }
    int mid=(l+h)/2;
    if(pos<=mid)update(nums,l,mid,pos,val,2*idx+1);
    else update(nums,mid+1,h,pos,val,2*idx+2);
    seg[idx]=seg[2*idx+1]+seg[2*idx+2];
}
public int get(int nums[],int l,int r,int left,int right,int idx){
    if(left>r||right<l)return 0;
    if(l>=left&&r<=right)return seg[idx];
    int mid=(l+r)/2;
    int x=get(nums,l,mid,left,right,2*idx+1);
    int y=get(nums,mid+1,r,left,right,2*idx+2);
    return x+y;
}
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */