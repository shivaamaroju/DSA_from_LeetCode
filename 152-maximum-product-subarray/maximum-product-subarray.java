class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
       int p[]=new  int[n];
       int s[]=new  int[n];
       p[0]=nums[0];
       s[n-1]=nums[n-1];
       for(int i=1;i<n;i++){
        if(p[i-1]!=0)
        p[i]=p[i-1]*nums[i];
        else p[i]=nums[i];
    }
       for(int i=n-2;i>=0;i--){
        if(s[i+1]!=0)
        s[i]=s[i+1]*nums[i];
        else s[i]=nums[i];
    }
    int max=Integer.MIN_VALUE;
    for(int i=0;i<n;i++){
        max=Math.max(max,Math.max(p[i],s[i]));
    }
    return max;
    }
}