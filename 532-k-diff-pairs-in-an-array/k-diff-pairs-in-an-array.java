class Solution {
    public int findPairs(int[] nums, int k) {

        int c=0;
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(var s:nums)mp.put(s,mp.getOrDefault(s,0)+1);
        for(var ss:mp.entrySet()){
            int s=ss.getKey();
            if(k==0){
                if(mp.get(s)>1)c++;
            }
            else{
                if(mp.containsKey(s+k))c++;
            }
        }
        return c;
    }
}