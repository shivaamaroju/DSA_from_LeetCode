class Solution {
    public boolean isBipartite(int[][] graph) {
        int n= graph.length;
        HashMap<Integer,List<Integer>> mp=new HashMap<>();
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++)
            mp.computeIfAbsent(i,k->new ArrayList<>()).add(graph[i][j]);
        }
    int col[]=new int[n];
    Arrays.fill(col,-1);
    boolean vis[]=new boolean[n];
    for(int i=0;i<n;i++){
        if(vis[i])continue;
    vis[i]=true;
    col[i]=0;
    Queue<Integer> q=new LinkedList<>();
    q.add(i);
    while(q.size()>0){
        int x=q.remove();
        int c=1-col[x];
        if(!mp.containsKey(x))continue;
        for(var s:mp.get(x)){
            if(vis[s]&&col[s]==col[x])return false;
            else if(!vis[s]){
                col[s]=c;
                vis[s]=true;
                q.add(s);}

        }
    }}
        return true;
    }
}