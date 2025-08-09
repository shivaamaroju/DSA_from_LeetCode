class Solution {
    public boolean canJump(int[] nums) {
        Boolean dp[]=new Boolean[nums.length];
        return helper(nums,0,dp);
    }
    public boolean helper(int nums[],int idx,Boolean dp[]){
        if(idx>=nums.length-1) return true;
        if(dp[idx]!=null)return dp[idx];
        for(int i=1;i<=nums[idx];i++){
          dp[idx] =  helper(nums,idx+i,dp);
          if(dp[idx])return true;
         
        }
        return false;
    }
}