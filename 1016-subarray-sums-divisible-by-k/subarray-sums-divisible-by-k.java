class Solution {
    public int subarraysDivByK(int[] nums, int k) {
int c=0;
int sum=0;
HashMap<Integer,Integer> mp=new HashMap<>();
mp.put(0,1);
       for(int i=0;i<nums.length;i++){
sum+=nums[i];
int r=(sum%k+k)%k;
if(mp.containsKey(r)){
    c+=mp.get(r);
}
mp.put(r,mp.getOrDefault(r,0)+1);
       } 
       return c;
    }
}