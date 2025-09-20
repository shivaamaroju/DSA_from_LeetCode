class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1)return true;
        Boolean dp[]=new Boolean[nums.length];
        return helper(nums,0,dp);
    }
    public boolean helper(int nums[],int idx,Boolean dp[]){
        if(idx>=nums.length-1)return true;
        if(dp[idx]!=null)return dp[idx];
        for(int i=1;i<=nums[idx];i++){
            if(helper(nums,idx+i,dp))return dp[idx]=true;
        }
        return dp[idx]=false;
    }
}