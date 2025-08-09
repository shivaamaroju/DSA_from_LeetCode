class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums, 0, dp);
    }

    public int helper(int[] nums, int idx, int[] dp) {
        if(idx>=nums.length-1)return 0;
        if(dp[idx]!=-1)return dp[idx];
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=nums[idx];i++){
            int nj=i+idx;
            if(nj<nums.length){
                int j=helper(nums,nj,dp);
               if(j!=Integer.MAX_VALUE)
                    min=Math.min(min,1+j);
                
            }

        }
        return dp[idx]=min;
    }
}
