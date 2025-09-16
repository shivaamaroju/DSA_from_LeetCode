class Solution {
    public int findMin(int[] nums) {
        int l=0,h=nums.length-1;
        int ans=-1;
        while(l<h){
            int mid=(l+h)/2;
            if(nums[mid]<=nums[h]){
                // ans=nums[mid];
                h=mid;
            }
            else l=mid+1;
        }
        return nums[l];
    }
}