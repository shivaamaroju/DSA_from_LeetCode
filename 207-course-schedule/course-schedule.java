class Solution {
    public boolean canFinish(int n, int[][] p) {
        HashMap<Integer,List<Integer>> mp=new HashMap<>();
        int in[]=new int[n];
        for(var s:p){
            mp.computeIfAbsent(s[1],k->new ArrayList<>()).add(s[0]);
        in[s[0]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        int c=0;
        for(int i=0;i<n;i++)if(in[i]==0)q.add(i);
        while(q.size()>0){
            int x=q.remove();
            c++;
        if(mp.containsKey(x)){
            for(int s:mp.get(x)){
                in[s]--;
                if(in[s]==0)q.add(s);
            }
        }
        }

    return c==n;}
}