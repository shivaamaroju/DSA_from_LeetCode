class Solution {
       int a[]=new int[1];
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {

        HashMap<Integer,List<Integer>> mp=new HashMap<>();
        for(var s:edges){
            int u=s[0];
            int v=s[1];
            mp.computeIfAbsent(u,m->new ArrayList<>()).add(v);
            mp.computeIfAbsent(v,m->new ArrayList<>()).add(u);
        }
        HashSet<Integer> hs=new HashSet<>();
        int size=n;
        int c=0;
 find(mp,values,k,0,-1);
        return a[0];
    }
    public int find(HashMap<Integer,List<Integer>> mp,int values[],int k,int node,int p){
int sum=values[node];
if(mp.containsKey(node)){
for(int s:mp.get(node)){
    if(s!=p){
sum+=find(mp,values,k,s,node);
    }
}}
if(sum%k==0)a[0]++;
return sum%k;
    }
}