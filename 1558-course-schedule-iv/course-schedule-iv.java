class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] p, int[][] q) {
      boolean vis[][]=new boolean[n][n];
      for(var s:p){
        int u=s[0];
        int v=s[1];
        vis[u][v]=true;
      }
      for(int k=0;k<n;k++){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
             if(i!=j&&j!=k&&i!=k&&vis[i][k]&&vis[k][j]&&!vis[i][j]){
                vis[i][j]=true;
             }   
            }
        }
      }
      List<Boolean> ans=new ArrayList<>();
      for(var s:q){
         int u=s[0];
        int v=s[1];
        ans.add(vis[u][v]);
      }
      return  ans;
    }
}