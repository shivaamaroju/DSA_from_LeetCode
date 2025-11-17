class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int x=0,prev=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1&&x==0){
                prev=i;
                x=1;
            }
           else if(nums[i]==1&&Math.abs(i-prev)>k){
            prev=i;
           }
           else if(nums[i]==1&&Math.abs(i-prev)<=k){
         return false;
           }
                   }
                   return true;
    }
}