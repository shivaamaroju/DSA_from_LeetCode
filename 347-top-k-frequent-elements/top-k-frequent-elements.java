class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(var s:nums){
            mp.put(s,mp.getOrDefault(s,0)+1);
        }
PriorityQueue<Integer> pq=new PriorityQueue<>((x,y)->{
return mp.get(y)-mp.get(x);
        });
        for(var s:mp.entrySet()){
            pq.add(s.getKey());
        }
        int a[]=new int[k];
        for(int i=0;i<k;i++)a[i]=pq.remove();
        return a;



    }
}