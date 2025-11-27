class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        HashMap<Integer,Integer> mp=new HashMap<>();
        mp.put(0,-1);
        if(sum%p==0)return 0;
        long r=(sum%p);
        long prefix=0;
        int ans=nums.length;
        for(int i=0;i<nums.length;i++){
            prefix+=nums[i];
        long t=(prefix-r+p)%p;
        if(mp.containsKey((int)t)){
ans=Math.min(ans,i-mp.get((int)t));
        }
        mp.put((int)(prefix % p),i);
        }
        return ans==nums.length?-1:ans;
    }
}