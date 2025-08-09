class Solution {
    int c=0;
    public int uniquePaths(int m, int n) {
        int a[][]=new int[m][n];
        boolean vis[][]=new boolean[m][n];
        int dp[][]=new int [m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return 
        helper(a,m,n,0,0,dp);
    }
    public int helper(int a[][],int m, int n,int i,int j,int dp[][]){
        if(i>=m||j>=n)return  0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(i==m-1&&j==n-1){
            return 1;
        }
      int x=  helper(a,m,n,i+1,j,dp);//down
       int y= helper(a,m,n,i,j+1,dp);//up
       return dp[i][j]=x+y;
    }
}