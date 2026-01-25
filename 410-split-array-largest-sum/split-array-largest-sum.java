class Solution {
    public int splitArray(int[] nums, int k) {
        int min=Integer.MIN_VALUE,sum=0;
        for(int s:nums){
min=Math.max(min,s);
sum+=s;
        }
        int l=min,h=sum;
        int ans=0;
        while(l<=h){
            int mid=(l+h)/2;
            if(fun(nums,mid)<=k){
ans=mid;
h=mid-1;
            }
           else l=mid+1;
        }
        return ans;
    }
    public int fun(int nums[],int sum){
        int c=1,st=nums[0];
        for(int i=1;i<nums.length;i++){
            if(st+nums[i]<=sum)st+=nums[i];
            else{
                c++;
                st=nums[i];
            }
        }
        return c;
    }
}