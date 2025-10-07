class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer,List<Pair>> mp=new HashMap<>();
        for(var s:flights){
            mp.computeIfAbsent(s[0],kl->new ArrayList<>()).add(new Pair(s[1],s[2]));
        }
       Queue<Pair> pq=new LinkedList<>();
        pq.add(new Pair(0,src,0));
        int dist[]=new int[n];
        Arrays.fill(dist,10000000);
        dist[src]=0;
while(pq.size()>0){
    Pair p=pq.remove();
    int cur=p.c;
    int d=p.dist;
    int ss=p.k;
    if(ss>k)continue;
    if(mp.containsKey(cur)){
    for(var s:mp.get(cur)){
        int dd=s.dist;
        int next=s.n;
        if(dist[next]>d+dd){
dist[next]=d+dd;
pq.add(new Pair(ss+1,next,dist[next]));
        }
    }
}}
return dist[dst] == 10000000 ? -1 : dist[dst];
    }
}
class Pair{
    int n,dist,k,c,d;
    Pair(int n,int dist){
        this.n=n;
        this.dist=dist;
    }
    Pair(int k,int c,int d){
        this.k=k;
        this.c=c;
        this.dist=d;
    }
}