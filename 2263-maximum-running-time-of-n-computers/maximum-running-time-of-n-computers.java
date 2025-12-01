class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum=0;
        for(var s:batteries)sum+=s;
    long l=1,h=sum;
    long ans=0;
    while(l<=h){
        long mid=(l+h)/2;
        if(bin(mid,batteries,n,sum)){
            ans=mid;
            l=mid+1;
        }
        else h=mid-1;
    }
    return ans;
    }
    public boolean bin(long t,int b[],int n,long os){
        long sum=0;
        for(int i=0;i<b.length;i++){
            sum+=Math.min(t,b[i]);
        }
        return sum>=(t*n);
    }
}