class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> mp=new HashMap<>();
        for(var s:words){
            mp.put(s,mp.getOrDefault(s,0)+1);
        }
        PriorityQueue<String> pq=new PriorityQueue<>((x,y)->{
            if(mp.get(x)==mp.get(y))return x.compareTo(y);
            else return mp.get(y)-mp.get(x);
        });
        for(var s:mp.entrySet()){
         pq.add(s.getKey());   
        }
        List<String> l=new ArrayList<>();
        for(int i=0;i<k;i++){
            l.add(pq.remove());
        }
        return l;
    }
}