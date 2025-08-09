class Solution {
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
       return helper(nums,0,dp);
    }
    public int helper(int a[],int idx,int dp[]){
        if(idx>=a.length)return 0;
if(dp[idx]!=-1)return dp[idx];
        int take=a[idx]+helper(a,idx+2,dp);
        int nottake=helper(a,idx+1,dp);
        return dp[idx]= Math.max(take,nottake);
    }
}