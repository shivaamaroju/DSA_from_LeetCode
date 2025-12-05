class Solution {
    public int countPartitions(int[] nums) {
        int c=0,d=0;
        int a[]=new int[nums.length];
        int b[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            c+=nums[i];
            a[i]+=c;
            d+=nums[nums.length-i-1];
            b[nums.length-i-1]+=d;
        }
        c=0;
        for(int i=1;i<nums.length;i++){
            if(Math.abs(a[i-1]-b[i])%2==0)c++;
        }
        return c;
    }
}