class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        HashSet<Integer> hs=new HashSet<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>((x,y)->y-x);
        for(var s:nums){
            if(!hs.contains(s)){
                pq.add(s);
                hs.add(s);}
        }
        int a[]=new int[Math.min(pq.size(),k)];
        int j=0;
        while(k-->0&&pq.size()>0)a[j++]=pq.remove();
        return a;
        
    }
}