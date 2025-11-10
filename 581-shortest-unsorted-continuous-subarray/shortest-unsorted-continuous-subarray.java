class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int x[]=nums.clone();
        Arrays.sort(nums);
        int c=-1;
        int max=-1;
        boolean f=true;
        for(int i=0;i<nums.length;i++){
           if(nums[i]!=x[i]&&f){
            c=i;
            f=false;}
           else if(nums[i]!=x[i]&&!f)max=i;
        }
       if(max==-1||c==-1)return 0;
        return max-c+1;        
    }
}