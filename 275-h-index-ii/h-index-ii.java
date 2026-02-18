class Solution {
    public int hIndex(int[] a) {
        int n=a.length;
        int l=a[0],h=a[n-1];
        int ans=n;
        while(l<=h){
            int mid=(l+h)/2;
            if(fun(mid,a)){
ans=mid;
l=mid+1;
            }
            else h=mid-1;
        }
        return ans;
    }
    public boolean fun(int mid,int a[]){
        int c=0;
        for(int s:a){
            if(s>=mid)c++;
            if(c>=mid)return true;
        }
        return c>=mid;
    }
}