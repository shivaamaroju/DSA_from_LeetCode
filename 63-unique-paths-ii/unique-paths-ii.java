class Solution {
    public int uniquePathsWithObstacles(int[][] a) {
        int n=a.length;
        int m=a[0].length;
        if(a[0][0]==1||a[n-1][m-1]==1)return 0;
        int dp[][]=new int[n][m];
        dp[0][0]=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]==1){
                    dp[i][j]=0;
                    continue;
                }
                int up=0,left=0;
                if(i-1>=0)up=dp[i-1][j];
                if(j-1>=0)left=dp[i][j-1];
                dp[i][j]+=up+left;
            }
        }
        return dp[n-1][m-1];


    }
}
