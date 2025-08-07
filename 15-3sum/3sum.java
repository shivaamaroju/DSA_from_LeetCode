class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
Arrays.sort(nums);
 HashSet<List<Integer>> l=new HashSet<>();
for(int i=0;i<nums.length;i++){
        HashSet<Integer> hs=new HashSet<>();
for(int j=i+1;j<nums.length;j++){
    int t=-(nums[i]+nums[j]);
    if(hs.contains(t)){
        List<Integer> ll=new ArrayList<>();
        ll.add(nums[i]);
        ll.add(nums[j]);
        ll.add(t);
        Collections.sort(ll);
        l.add(ll);
    }
    hs.add(nums[j]);
}

}
return new ArrayList<>(l);

    }
}