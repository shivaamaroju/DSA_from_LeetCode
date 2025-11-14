class Solution {
    public int[][] rangeAddQueries(int n, int[][] q) {
      int a[]=new int[n*n];
      int ans[][]=new int[n][n];
      for(int x[]:q){
for(int i=x[0];i<=x[2];i++){
    for(int j=x[1];j<=x[3];j++){
        ans[i][j]+=1;
    }
}
      }

      return ans;

    }
}