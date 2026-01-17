class Solution {
    public int minPathSum(int[][] a) {
        int m=a.length;
        int n=a[0].length;
        int dp[][]=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int up=(int)1e9,down=(int)1e9;
                if(i-1>=0)up=dp[i-1][j];
                if(j-1>=0)down=dp[i][j-1];
                int min=Math.min(up,down);
               if(min!=1e9)dp[i][j]=min;
               dp[i][j]+=a[i][j];
            }
        }
        return dp[m-1][n-1];
    }
    public int fun(int a[][],int i,int j){

if(i==0&&j==0)return a[i][j];
if(i<0||j<0)return (int)1e9;
int up=a[i][j]+fun(a,i-1,j);
int down=a[i][j]+fun(a,i,j-1);
return Math.min(up,down);}
}