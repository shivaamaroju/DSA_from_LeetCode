class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans=new ArrayList<>();
        int x=0;
        for(var s:nums){
x=(x<<1)|s;
ans.add(x%5==0);
x=x%5;

        }
        return ans;
    }
}