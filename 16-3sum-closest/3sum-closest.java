class Solution {
    public int threeSumClosest(int[] nums, int t) {
        Arrays.sort(nums);
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){
            int l=i+1;
            int r=nums.length-1;
            while(l<r){
                int sum=nums[i]+nums[l]+nums[r];
                if(Math.abs(t-sum)<Math.abs(t-ans)){
                    ans=sum;
                }
                if(sum<t)l++;
                else if(sum>t)r--;
else return sum;
            }
        }
        return ans;
    }
}