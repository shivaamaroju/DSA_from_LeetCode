class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean vis[]=new boolean[n];
        dfs(0,rooms,vis);
        for(var s:vis)if(!s)return s;
    return true;
    }
    public void dfs(int node,List<List<Integer>> rooms,boolean vis[]){
        if(vis[node])return;
vis[node]=true;
for(var s:rooms.get(node)){
dfs(s,rooms,vis);
}

    }
}