class Solution {
    public boolean possibleBipartition(int n, int[][] d) {
int col[]=new int[n+1];
boolean hsd[]=new boolean[n+1];
Arrays.fill(col,-1);
if(d.length==0)return true;
HashMap<Integer,List<Integer>> mp=new HashMap<>();
for(var s:d){
hsd[s[0]]=true;
hsd[s[1]]=true;
    mp.computeIfAbsent(s[0],k->new ArrayList<>()).add(s[1]);
    mp.computeIfAbsent(s[1],k->new ArrayList<>()).add(s[0]);
}
for(int i=1;i<=n;i++){
    if(col[i]!=-1)continue;
Queue<Integer> q=new LinkedList<>();
q.add(i);
col[i]=0;
while(q.size()>0){
    int x=q.remove();
if(!mp.containsKey(x))continue;
    for(int s:mp.get(x)){
        if(col[x]==col[s])return false;
        if(col[s]==-1){
            q.add(s);
            col[s]=1-col[x];
        }
    }

}}

return true; 
}
}
/*



*/