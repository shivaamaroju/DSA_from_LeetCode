class Solution {
    public int change(int a, int[] c) {
        int n=c.length;
        int dp[][]=new int[n+1][a+1];
        for(int i=0;i<n+1;i++){
            dp[i][0]=1;
        }
        for(int i=n-1;i>=0;i--){
            for(int j=1;j<=a;j++){
                dp[i][j]=dp[i+1][j];
                if(c[i]<=j)dp[i][j]+=dp[i][j-c[i]];
            }
        }
        return dp[0][a];
    }
}