class Solution {
    public long gcdSum(int[] nums) {
        int n=nums.length;
        int p[]=new int[n];
        p[0]=nums[0];
        int ans[]=new int[n];
        ans[0]=nums[0];
        for(int i=1;i<n;i++){
        p[i]=Math.max(p[i-1],nums[i]);
        ans[i]=gcd(p[i],nums[i]);
        // System.out.println(ans[i]);
        }
        int l=0,h=n-1;
        Arrays.sort(ans);
        long sum=0;
    while(l<h){
        sum+=gcd(ans[h--],ans[l++]);


    }



        return sum;
    }
    public int gcd(int a,int b){
        if(b<=0)return a;
        return gcd(b,a%b);
    }
}