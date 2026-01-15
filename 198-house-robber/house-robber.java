class Solution {
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            int t=nums[i],nt=0;
           if(i-2>=0)
           t+=dp[i-2];
           nt=dp[i-1];
       dp[i]=Math.max(t,nt);

        }
        return dp[nums.length-1];
    }
    public int helper(int idx,int nums[]){
        if(idx>=nums.length)return 0;
        int take=nums[idx]+helper(idx+2,nums);
        int ntake=helper(idx+1,nums);
    return Math.max(take,ntake);
    }
}