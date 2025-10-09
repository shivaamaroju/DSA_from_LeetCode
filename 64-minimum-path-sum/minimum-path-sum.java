class Solution {
    public int minPathSum(int[][] grid) {
        int dp[][]=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(grid,0,0,grid.length,grid[0].length,dp);
    }
    public int helper(int a[][],int i,int j,int m,int n, int dp[][]){
        if(i>=m||j>=n)return Integer.MAX_VALUE;
        if(dp[i][j]!=-1)return dp[i][j];
        if(i==m-1&&j==n-1){
           return a[i][j];
        }
       int x= helper(a,i+1,j,m,n,dp);
       int y= helper(a,i,j+1,m,n,dp);
     return  dp[i][j]=a[i][j]+Math.min(x,y);
    }
}