class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer,List<Pair>> mp=new HashMap<>();
        for(var s:times){
            mp.computeIfAbsent(s[0],l->new ArrayList<>()).add(new Pair(s[1],s[2]));
        }

        int dist[]=new int[n+1];
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->a.w-b.w);
        q.add(new Pair(k,0));
        Arrays.fill(dist,(int)1e9);
        dist[k]=0;
        while(q.size()>0){
            Pair x=q.remove();
            if(mp.containsKey(x.n)){
                for(var s:mp.get(x.n)){
                    if(dist[s.n]>dist[x.n]+s.w){
                        dist[s.n]=dist[x.n]+s.w;
                        q.add(new Pair(s.n,dist[s.n]));
                    }
                }
            }
        }
        int max=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==(int)1e9)return -1;
max=Math.max(dist[i],max);
        }
        return max;





       
    }
}
class Pair{
    int n,w;
    Pair(int n,int w){
        this.n=n;
        this.w=w;
    }
}