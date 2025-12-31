class Solution {
    public void nextPermutation(int[] nums) {
        int i=find(nums);
       
       int j=find2(nums,i);
       if(i==j){
        reverse(nums,0);
        return;
       }
        System.out.println(j);
       swap(nums,i,j);
       reverse(nums,i+1);
       
    }
    public int find(int nums[]){
        int idx=0;
        for(int i=nums.length-2;i>=0;i--){
        if(nums[i]<nums[i+1])return i;
        }
        return idx;
    }
    public int find2(int nums[],int j){
        for(int i=nums.length-1;i>j;i--){
            if(nums[j]<nums[i])return i;
        }
        return j;
    }
    public void swap(int nums[],int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void reverse(int nums[],int k){
        int j=0;
    for(int i=k;i<nums.length;i++){
        if(i<nums.length-j-1){
        int temp=nums[i];
        nums[i]=nums[nums.length-j-1];
        nums[nums.length-j-1]=temp;
        j++;}
    }
    }
}