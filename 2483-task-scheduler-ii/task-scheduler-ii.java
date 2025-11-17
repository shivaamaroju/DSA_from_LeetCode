class Solution {
    public long taskSchedulerII(int[] t, int s) {
        long c=0;
        if(t.length==1)return 1;
        HashMap<Integer,Long> mp=new HashMap<>();
        int n=t.length;
        for(int i=0;i<n;i++){
            int task=t[i];
            if(!mp.containsKey(task)){
                c++;
                mp.put(task,c-1);
            }
            else{
                long idx=mp.get(task);
                if((c-idx-1)>=s)c++;
                else{
c+=(s-((c-idx-1)))+1;
                }
mp.put(task,c-1);
            }
        }
        return c;
    }
}