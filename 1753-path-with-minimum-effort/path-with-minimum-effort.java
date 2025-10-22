class Solution {
    public int minimumEffortPath(int[][] a) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((az,b)->az.d-b.d);
        int n=a.length;
        int m=a[0].length;
        int dist[][]=new int[n][m];
        for(int i=0;i<n;i++)Arrays.fill(dist[i],(int)1e9);
        pq.add(new Pair(0,0,0));
        dist[0][0]=0;
        while(pq.size()>0){
            Pair p=pq.remove();
            int d=p.d;
            int x=p.x;
            int y=p.y;
            if(x==n-1&&y==m-1)return dist[n-1][m-1];
            if(x+1<n&&dist[x+1][y]>Math.max(d,Math.abs(a[x][y]-a[x+1][y]))){
dist[x+1][y]=Math.max(d,Math.abs(a[x][y]-a[x+1][y]));
pq.add(new Pair(Math.max(d,Math.abs(a[x][y]-a[x+1][y])),x+1,y));
            }
            if(y+1<m&&dist[x][y+1]>Math.max(d,Math.abs(a[x][y]-a[x][y+1]))){
dist[x][y+1]=Math.max(d,Math.abs(a[x][y]-a[x][y+1]));
pq.add(new Pair(Math.max(d,Math.abs(a[x][y]-a[x][y+1])),x,y+1));
            }
            if(y-1>=0&&dist[x][y-1]>Math.max(d,Math.abs(a[x][y]-a[x][y-1]))){
dist[x][y-1]=Math.max(d,Math.abs(a[x][y]-a[x][y-1]));
pq.add(new Pair(Math.max(d,Math.abs(a[x][y]-a[x][y-1])),x,y-1));
            }
               if(x-1>=0&&dist[x-1][y]>Math.max(d,Math.abs(a[x][y]-a[x-1][y]))){
dist[x-1][y]=Math.max(d,Math.abs(a[x][y]-a[x-1][y]));
pq.add(new Pair(Math.max(d,Math.abs(a[x][y]-a[x-1][y])),x-1,y));
            }


        }
        return dist[n-1][m-1];
    }
}
class Pair{
    int d,x,y;
    Pair(int d,int x,int y){
        this.d=d;
        this.x=x;
        this.y=y;
    }
}