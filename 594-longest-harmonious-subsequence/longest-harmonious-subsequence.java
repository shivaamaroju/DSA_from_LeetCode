class Solution {
    public int findLHS(int[] nums) {
      TreeMap<Integer,Integer> mp=new TreeMap<>();
      for(var s:nums){
        mp.put(s,mp.getOrDefault(s,0)+1);
      }
      int c=0,max=0;
for(var s:mp.entrySet()){
int x=s.getKey();
if(mp.containsKey(x+1)){
    max=Math.max(max,mp.get(x)+mp.get(x+1));
}}
return max;
    }
}