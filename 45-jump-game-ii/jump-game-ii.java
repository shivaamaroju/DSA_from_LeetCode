class Solution {
    public int jump(int[] nums) {
        int l=0,r=0,j=0,n=nums.length;
while(r<n-1){
j++;
int maxf=0;
for(int i=l;i<=r;i++){
    maxf=Math.max(maxf,nums[i]+i);
}
l=r+1;
r=maxf;

}
return j;
    }
}