class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
    HashSet<List<Integer>> hs1=new HashSet<>();
        for(int i=0;i<nums.length;i++){
           HashSet<Integer> hs=new HashSet<>();
            for(int j=i+1;j<nums.length;j++){
                int temp=-(nums[i]+nums[j]);
                if(hs.contains(temp)){
                    List<Integer> l=new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(temp);
                    hs1.add(l);
                }
                hs.add(nums[j]);
            }
        }
        return new ArrayList<>(hs1);
    }
}