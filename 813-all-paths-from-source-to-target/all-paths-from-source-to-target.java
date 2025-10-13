class Solution {
HashSet<List<Integer>> ans=new HashSet<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
boolean vis[]=new boolean[graph.length];
if(graph[0].length==0)return new ArrayList<>();
List<Integer> l=new ArrayList<>();
for(int i=0;i<graph[0].length;i++){
helper(0,graph.length-1,graph,l);
}
for(var s: ans){
    s.add(0,0);
}
return new ArrayList<>(ans);

    }
    public void helper(int src,int t,int a[][],List<Integer> l){
        if(src==t){
            ans.add(new ArrayList<>(l));
            return;
        }
        for(int i=0;i<a[src].length;i++){
            l.add(a[src][i]);
            helper(a[src][i],t,a,l);
            l.remove(l.size()-1);
        }
    }
}