class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int a[]=new int[value];
        for(int i=0;i<nums.length;i++){
        int x=nums[i];
        x=((x%value)+value)%value;
        a[x]++;
        }
        for(int i=0;i<nums.length;i++){
          int  x=i%value;
            if(a[x]<=0)return i;
            a[x]--;
        }
        return nums.length;

    }
}