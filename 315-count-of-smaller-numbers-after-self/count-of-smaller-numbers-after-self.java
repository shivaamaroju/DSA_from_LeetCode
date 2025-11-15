class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer>l=new ArrayList<>();
        int max=0,nmax=0;
        for(int x:nums){
            if(x>=0)max=Math.max(max,x);
            else nmax=Math.max(nmax,-x);
        }
        int pnumf[]=new int[max+1];
        int nnumf[]=new int[nmax+1];
        for(int x:nums){
            if(x>=0)pnumf[x]++;
            else nnumf[-x]++;
        }
        SEG POS=new SEG(max+1);
        SEG NEG=new SEG(nmax+1);
        POS.build(0,0,max,pnumf);
        NEG.build(0,0,nmax,nnumf);
        for(int  x:nums){
if(x>=0){
POS.update(0,0,max,x,-1);
int pos= x>0?POS.sum(0,0,max,0,x-1):0;
int neg=NEG.sum(0,0,nmax,0,nmax);
l.add(pos+neg);
}
else{
    int idx=-x;
    int nsum=(idx<nmax)?
  NEG.sum(0,0,nmax,idx+1,nmax):0;
  l.add(nsum);
    NEG.update(0,0,nmax,-x,-1);

}
        }
return l;
    }
}

class SEG{
int seg[];
SEG(int n){
    seg=new int [4*n];
}
public void build(int idx, int l,int h,int a[]){
    if(l==h){
        seg[idx]=a[l];
        return;
    }
    int mid=(l+h)/2;

    build(2*idx+1,l,mid,a);
    build(2*idx+2,mid+1,h,a);
    seg[idx]=seg[2*idx+1]+seg[2*idx+2];
}
public void update(int idx,int l,int h,int i,int val){
    if(l==h){
        seg[idx]+=val;
        return;
    }
    int mid=(l+h)/2;
    if(i<=mid)update(2*idx+1,l,mid,i,val);
    else update(2*idx+2,mid+1,h,i,val);
    seg[idx]=seg[2*idx+1]+seg[2*idx+2];
}
public int sum(int idx,int l,int h,int left,int right){
    if(l>right||h<left)return 0;
    if(l>=left&&h<=right)return seg[idx];
    int mid=(l+h)/2;
    int ll=sum(2*idx+1,l,mid,left,right);
    int rr=sum(2*idx+2,mid+1,h,left,right);
    return ll+rr;
}}