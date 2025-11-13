class Solution {
    public int wiggleMaxLength(int[] nums) {
       int  prev=0;
        int x=nums[0];
        int c=1;
        for(int i=1;i<nums.length;i++){
int diff=nums[i]-x;
if(diff==0)continue;
if(diff<0)diff=Integer.MIN_VALUE;
else if(diff>0) diff=Integer.MAX_VALUE;
if(diff!=prev){
    c++;
    prev=diff;
}
    x=nums[i];
        }
        return c;
    }
}