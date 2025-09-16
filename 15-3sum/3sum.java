class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> hs=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            HashSet<Integer> hs1=new HashSet<>();
            for(int j=i+1;j<nums.length;j++){
              int t  =- (nums[i] + nums[j]);
                if(hs1.contains(t)){
                    List<Integer> l=new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(t);
                Collections.sort(l);
                hs.add(l);
                }
                hs1.add(nums[j]);
            }
        }
        List<List<Integer>> l=new ArrayList<>(hs);
        return l;
    }
}