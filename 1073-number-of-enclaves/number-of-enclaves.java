class Solution {
    public int numEnclaves(int[][] a) {
        int m=a.length;
        int n=a[0].length;
        boolean vis[][]=new boolean[m][n];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0||j==0||i==m-1||j==n-1)&&a[i][j]==1){
                    q.add(new Pair(i,j));
                    a[i][j]=0;}
            }
        }
        int dx[]={0,-1,0,1};
        int dy[]={-1,0,1,0};
        while(q.size()>0){
            Pair p=q.remove();
            int x=p.x;
            int y=p.y;
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(nx<m&&ny<n&&nx>=0&&ny>=0&&a[nx][ny]==1){
                   a[nx][ny]=0;
                    q.add(new Pair(nx,ny));
                }
            }

        }
        int c=0;
        for(var s:a){
            for(var ss:s)if(ss==1)c++;
        }
        return c;

    }
}
class Pair{
    int x,y;
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}