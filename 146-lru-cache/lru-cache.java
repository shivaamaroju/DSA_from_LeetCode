class LRUCache {
LinkedHashMap<Integer,Integer> mp;
int c;
    public LRUCache(int capacity) {
      c=capacity;
      mp=new LinkedHashMap<>(c,0.75f,true);  
    }
    
    public int get(int key) {
        return mp.getOrDefault(key,-1);
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key))
        mp.put(key,value);
        else{
            if(mp.size()==c){
                int r=mp.keySet().iterator().next();
                mp.remove(r);
            }
            mp.put(key,value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */