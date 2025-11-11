class NumArray {
SEG obj;
int n;
    public NumArray(int[] nums) {
        n=nums.length;
        obj=new SEG(nums.length);
        obj.build(0,0,nums.length-1,nums);
    }
    
    public void update(int index, int val) {
        obj.update(0,0,n-1,index,val);
        // for(int s:obj.seg)
        // System.out.print(s+" ");
        // System.out.println(" ");
    }
    
    public int sumRange(int left, int right) {
        return obj.sum(0,0,n-1,left,right);
    }
}
class SEG{
    int seg[];
    SEG(int n){
        seg=new int[4*n];
    }
    public void build(int idx,int l, int h,int a[]){
        if(l==h){
            seg[idx]=a[l];
            return ;
        }
        int mid=(l+h)/2;
        build(2*idx+1,l,mid,a);
        build(2*idx+2,mid+1,h,a);
        seg[idx]=seg[2*idx+1]+seg[2*idx+2];
    }
    public void update(int idx,int l,int h,int i,int val){
if(l==h){
    seg[idx]=val;
    return;
}
int mid=(l+h)/2;
if(i<=mid)
update(2*idx+1,l,mid,i,val);
else
update(2*idx+2,mid+1,h,i,val);
  seg[idx]=seg[2*idx+1]+seg[2*idx+2];

    }
    public int sum(int idx,int l,int h,int left,int right){
        if(right<l||h<left)return 0;
        if (left <= l && h <= right) return seg[idx];

        else{
        int mid=(l+h)/2;
        int ll=sum(2*idx+1,l,mid,left,right);
        int rr=sum(2*idx+2,mid+1,h,left,right);
      
        return ll+rr;}

    }
}