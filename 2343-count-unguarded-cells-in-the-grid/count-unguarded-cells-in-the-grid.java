class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char g[][]=new char[m][n];
        for(var s:guards){
            int i=s[0];
            int j=s[1];
            g [i][j]='G';
        }
        for(var s:walls){
            int i=s[0];
            int j=s[1];
            g [i][j]='W';
        }
        boolean vis[][]=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(g[i][j]=='G'&&!vis[i][j]){
                    vis[i][j]=true;
                    fun(g,vis,i,j,m,n);
                }
            }
        }
        int c=0;
    for(var s:g){
        for(var ss:s)if(ss!='S'&&ss!='W'&&ss!='G')c++;
    }
    return c;
    }
    public void fun(char g[][],boolean vis[][],int i,int j,int m,int n){
        for(int k=i-1;k>=0&&g[k][j]!='W'&&g[k][j]!='G';k--){
g[k][j]='S';
        }
        for(int k=i+1;k<m&&g[k][j]!='W'&&g[k][j]!='G';k++){
g[k][j]='S';
        }
        for(int k=j+1;k<n&&g[i][k]!='W'&&g[i][k]!='G';k++){
g[i][k]='S';
        }
        for(int k=j-1;k>=0&&g[i][k]!='W'&&g[i][k]!='G';k--){
g[i][k]='S';
        }
        
    }
}