class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans=0;
        int st=0;
        for(int i=0;i<nums.length;i++){
            while(st<=i&&nums[i]!=0){
                st++;
            }
            if(st<nums.length&&nums[st]==0&&nums[i]==0)ans+=(i-st)+1;
        }
        return ans;

    }
}