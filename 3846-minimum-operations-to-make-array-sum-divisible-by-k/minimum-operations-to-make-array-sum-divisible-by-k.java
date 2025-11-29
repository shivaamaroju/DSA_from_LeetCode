class Solution {
    public int minOperations(int[] nums, int k) {
        int sum=0;
        for(var s:nums){
            sum+=s;
        }
        
        return sum%k;
    }
}