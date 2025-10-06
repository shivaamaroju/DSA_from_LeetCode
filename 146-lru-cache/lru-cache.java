class LRUCache {
LinkedHashMap<Integer,Integer>mp;
int c;
    public LRUCache(int capacity) {
     c=capacity;
     mp=new LinkedHashMap<>(c,0.75f,true);
    }
    
    public int get(int key) {
       return mp.getOrDefault(key,-1);
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            mp.put(key,value);
        }
        else{
            if(mp.size()==c){
                int x=mp.keySet().iterator().next();
                mp.remove(x);
            }
            mp.put(key,value);
        }
    }
}
