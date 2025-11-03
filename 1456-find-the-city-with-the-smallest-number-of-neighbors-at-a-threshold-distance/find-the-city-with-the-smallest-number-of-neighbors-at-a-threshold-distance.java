class Solution {
    public int findTheCity(int n, int[][] edges, int t) {
        int max=n;
        int a[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(a[i],Integer.MAX_VALUE);
            a[i][i]=0;
        }
        for(int s[]:edges){
            int u=s[0];
            int v=s[1];
           
            int w=s[2];
            a[u][v]=w;
            a[v][u]=w;
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(a[i][k]==Integer.MAX_VALUE||a[k][j]==Integer.MAX_VALUE)continue;
                    a[i][j]=Math.min(a[i][j],a[i][k]+a[k][j]);
                }
            }
        }
        int city=0;
        for(int i=0;i<n;i++){
            int c=0;
            for(int j=0;j<n;j++){
if(a[i][j]<=t)c++;
            }
            if(c<=max){
                max=Math.min(max,c);
                city=i;
            }
        }
return city;

    }
}