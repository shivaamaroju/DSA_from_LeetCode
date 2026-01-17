class Solution {
    public int minFallingPathSum(int[][] a) {
        int n=a.length;
        int m=a[0].length;
        int dp[][]=new int[n][m];
        for(int i=0;i<m;i++)dp[0][i]=a[0][i];
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                int upl=(int)1e9;
                int up=(int)1e9;
                int upr=(int)1e9;
              if(j-1>=0)  upl=dp[i-1][j-1];
                  up=dp[i-1][j];
               if(j+1<m)   upr=dp[i-1][j+1];
               dp[i][j]=a[i][j]+Math.min(up,Math.min(upr,upl));
            }
        }
        int min=(int)1e9;
        for(int i=0;i<m;i++){
            min=Math.min(min,dp[n-1][i]);
        }
        return min;
    }
}