class NumArray {
sums obj;
int n;
    public NumArray(int[] nums) {
        obj=new sums(nums.length);
        n=nums.length;
        obj.helper(nums,0,nums.length-1,0);

    }
    
    public void update(int index, int val) {
        obj.updatetil(obj.seg,0,n-1,index,val,0);
    }
    
    public int sumRange(int left, int right) {
        return obj.getsum(obj.seg,0,n-1,left,right,0);
    }
}
class sums{
   int seg[];
   sums(int n){
    seg=new int[4*n];
   }
   public void helper(int nums[],int l,int r,int idx){
    if(l==r){
        seg[idx]=nums[l];
        return;
    }
    int mid=(l+r)/2;
    helper(nums,l,mid,2*idx+1);
    helper(nums,mid+1,r,2*idx+2);
    seg[idx]=seg[2*idx+1]+seg[2*idx+2];
   }
public void updatetil(int nums[],int l,int h,int pos,int val,int idx){
if(l==h){
    seg[idx]=val;
    return;
}
int mid=(l+h)/2;
if(pos<=mid)updatetil(nums,l,mid,pos,val,2*idx+1);
else updatetil(nums,mid+1,h,pos,val,2*idx+2);
seg[idx]=seg[2*idx+1]+seg[2*idx+2];
}
public int getsum(int nums[],int l,int r,int left,int right, int idx){
if(left>r||right<l)return 0;
if(l>=left&&r<=right)return seg[idx];
int mid=(l+r)/2;

int x=getsum(nums,l,mid,left,right,2*idx+1);
int y=getsum(nums,mid+1,r,left,right,2*idx+2);
return x+y;
}}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */