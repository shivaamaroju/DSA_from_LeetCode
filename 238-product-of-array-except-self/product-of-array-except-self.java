class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int p[]=new int[n];
        int s[]=new int[n];
        int r[]=new int[n];
        p[0]=nums[0];
        for(int i=1;i<n;i++){
            p[i]=p[i-1]*nums[i];
        }
        s[n-1]=nums[n-1];
        for(int j=n-2;j>=0;j--){
            s[j]=s[j+1]*nums[j];
        }
        for(int i=0;i<n;i++){
            int l=(i-1)>=0 ? p[i-1] : 1;
            int re=(i+1<n) ? s[i+1] : 1;
            r[i]=l*re;
        }
        return r;
    }
}