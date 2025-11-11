class Solution {
    public boolean canFinish(int n, int[][] p) {
        List<Integer> l=new ArrayList<>();
        int f[]=new int[n];
        HashMap<Integer,List<Integer>> mp=new HashMap<>();
        for(int i=0;i<p.length;i++){
            int x=p[i][0];
            int y=p[i][1];
f[x]++;
mp.computeIfAbsent(y,k->new ArrayList()).add(x);
    }
    Queue<Integer>q=new LinkedList<>();
    for(int i=0;i<n;i++)if(f[i]==0)q.add(i);
    while(q.size()>0){
        int x=q.remove();
        l.add(x);
        if(!mp.containsKey(x))continue;
        for(int s:mp.get(x)){
            f[s]--;
            if(f[s]==0)q.add(s);
        }
    }
    return l.size()==n;
        }
}