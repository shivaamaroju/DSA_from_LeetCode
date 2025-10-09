class Solution {
    public int orangesRotting(int[][] a) {
        int m=a.length,n=a[0].length;
        boolean vis[][]=new boolean[m][n];
        int c=0;
        Queue<pair> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a[i][j]==2){
                    q.add(new pair(i,j));
                    vis[i][j]=true;
                }
                else if(a[i][j]==1)c++;
            }
        }
        if(c==0)return 0;
        int t=0;
        while(q.size()>0){
int nn=q.size();
t++;
while(nn-->0){
    pair p=q.remove();
    int i=p.i;
    int j=p.j;
    if(i-1>=0&&a[i-1][j]==1){
        a[i-1][j]=2;
        c--;
        q.add(new pair(i-1,j));
    }
    if(j-1>=0&&a[i][j-1]==1){
        a[i][j-1]=2;
        c--;
        q.add(new pair(i,j-1));
    }
    if(j+1<a[0].length&&a[i][j+1]==1){
        a[i][j+1]=2;
        c--;
        q.add(new pair(i,j+1));
    }
    if(i+1<a.length&&a[i+1][j]==1){
        a[i+1][j]=2;
        c--;
        q.add(new pair(i+1,j));
    }
}

        }
        return c==0? t-1:-1;
    }
}
class pair{
    int i,j;
    pair(int i,int j){
        this.i=i;
        this.j=j;
    }
}