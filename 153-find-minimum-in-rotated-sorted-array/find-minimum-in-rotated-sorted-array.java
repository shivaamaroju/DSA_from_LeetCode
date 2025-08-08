class Solution {
    public int findMin(int[] nums) {
        int min=nums[0];
        int l=0,h=nums.length-1;
        while(l<h){
            int mid=(l+h)/2;
            if(nums[mid]>nums[h]){
                l=mid+1;
            }
            else h=mid;
        }
        return nums[l];
    }
}