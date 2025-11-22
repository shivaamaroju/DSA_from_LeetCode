class Solution {
    public int minimumOperations(int[] nums) {
        int c=0;
        for(var s:nums){
            if(s%3!=0)c++;
        }
        return c;
    }
}