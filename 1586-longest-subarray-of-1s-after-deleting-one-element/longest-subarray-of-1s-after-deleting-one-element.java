class Solution {
    public int longestSubarray(int[] nums) {
        int st=0,max=0,maxfreq=0;
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
          while(st<=i&&nums[i]==0&&mp.get(nums[i])>=2){
int x=mp.get(nums[st]);
if(x==1)mp.remove(x);
else mp.put(nums[st],x-1);
st++;
          }
          max=Math.max(max,i-st);

        }
        return max;
    }
}