class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> l=new ArrayList<>();
        HashSet<List<Integer>> hs=new HashSet<>();
        helper(nums,0,new ArrayList<>(),hs);
        for(var s:hs){
            l.add(s);
        }
        return l;
    }
    public void helper(int nums[],int idx,List<Integer> l,HashSet<List<Integer>> hs){
        if(idx==nums.length){
            List<Integer> hsl=new ArrayList<>();
            for(int s :nums){
                hsl.add(s);
            }
            hs.add(hsl);
            return;
        }
        for(int i=idx;i<nums.length;i++){
            swap(nums,i,idx);
            helper(nums,idx+1,l,hs);
            swap(nums,i,idx);
        }
    }
    public void swap(int nums[],int i,int j){
        if(i!=j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
    }
}