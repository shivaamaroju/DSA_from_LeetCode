class Solution {
    public int uniquePaths(int m, int n) {
              int dp[][]=new int[m][n];
              dp[m-1][n-1]=1;
              for(int i=m-1;i>=0;i--){
                for(int j=n-1;j>=0;j--){
                    if(i==m-1&&j==n-1)continue;
                    int l=(i+1<m) ? dp[i+1][j]:0;
                    int d=(j+1<n) ? dp[i][j+1]:0;
                    dp[i][j]=l+d;
                }
              }
return dp[0][0];
    }
}