class Solution {
    public int subarraySum(int[] nums, int k) {
        int c=0,sum=0;
        HashMap<Integer,Integer> mp=new HashMap<>();
        mp.put(0,1);
        for(var s:nums){
sum+=s;
if(mp.containsKey(sum-k))c+=mp.get(sum-k);
mp.put(sum,mp.getOrDefault(sum,0)+1);

        }
        return c;
    }
}