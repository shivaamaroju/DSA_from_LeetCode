class Solution {
    public int peopleAwareOfSecret(int n, int d, int f) {

        long dp[]=new long[n+1];
        dp[1]=1;
        int mod=(int)1e9+7;
        for(int i=1;i<=n;i++){
            for(int j=i+d;j<i+f&&j<=n;j++){
                dp[j]=(dp[j]+dp[i])%mod;
            }
        }
        long ans=0;
        for(int i=1;i<=n;i++){
            if(i+f>n)
            ans=(ans+dp[i])%mod;
        }
        return (int)ans;
    }
}