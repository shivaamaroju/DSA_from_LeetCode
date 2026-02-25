class Solution {
    public boolean canFinish(int n, int[][] a) {
        int in[]=new int[n];
        HashMap<Integer,List<Integer>> mp=new HashMap<>();
        for(var s:a){
            in[s[0]]++;
            mp.computeIfAbsent(s[1],k->new ArrayList<>()).add(s[0]);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++)if(in[i]==0)q.add(i);
        List<Integer> ans=new ArrayList<>();
        while(q.size()>0){
            int x=q.remove();
            ans.add(x);
            if(!mp.containsKey(x))continue;
            for(var s:mp.get(x)){
                in[s]--;
                if(in[s]==0){
                    q.add(s);
                }
            }
        }
        return ans.size()==n;
    }
}