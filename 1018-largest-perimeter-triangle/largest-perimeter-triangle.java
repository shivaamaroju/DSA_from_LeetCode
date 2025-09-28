class Solution {
    public int largestPerimeter(int[] nums) {
        int max=0;
        Arrays.sort(nums);
        // int n=nums.
        for(int i=nums.length-1;i>=2;i--){
            int a=nums[i],b=nums[i-1],c=nums[i-2];
            if((a+b>c)&&(b+c>a)&&(c+a>b))max=Math.max(max,a+b+c);
        }
        return max;
    }
}