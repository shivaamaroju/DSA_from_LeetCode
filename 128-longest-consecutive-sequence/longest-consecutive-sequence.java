class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)return 0;
        Arrays.sort(nums);
        int cur=1,max=1;
        int prev=nums[0];
        for(int i=1;i<nums.length;i++){
            if(prev==nums[i])continue;
            if(prev+1==nums[i]){
                cur++;
                max=Math.max(cur,max);
            }
            else{
                cur=1;
            }
                prev=nums[i];
        }
        return max;
    }
}