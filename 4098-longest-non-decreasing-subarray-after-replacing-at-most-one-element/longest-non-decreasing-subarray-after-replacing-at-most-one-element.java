class Solution {
    public int longestSubarray(int[] a) {
        int n=a.length;
        int l[]=new int[n];
        int r[]=new int[n];
        Arrays.fill(l,1);
        Arrays.fill(r,1);
        for(int i=1;i<n;i++)if(a[i]>=a[i-1])l[i]=l[i-1]+1;
        for(int i=n-2;i>=0;i--)if(a[i]<=a[i+1])r[i]=r[i+1]+1;
        int ans=1;
        if(n>1){
            ans=Math.max(ans,Math.max(l[n-2]+1,r[1]+1));
        }
        for(int i=1;i<n-1;i++){
            if(a[i-1]<=a[i+1]){
                ans=Math.max(ans,l[i-1]+r[i+1]+1);
            }
            ans=Math.max(ans,l[i-1]+1);
            ans=Math.max(ans,r[i+1]+1);
        }
        return ans;
    }
}