class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        HashMap<Integer,Long> mp=new HashMap<>();
        long ans=Long.MIN_VALUE;
        long prefix=0;
        mp.put(0,0L);
        for(int i=0;i<nums.length;i++){
            prefix+=nums[i];
            int idx=(i+1)%k;
            if(mp.containsKey(idx)){
                ans=Math.max(ans,prefix-mp.get(idx));
            }
            if(!mp.containsKey(idx)||prefix<mp.get(idx)){
                mp.put(idx,prefix);
            }
            
        }
        return ans;
    }
}