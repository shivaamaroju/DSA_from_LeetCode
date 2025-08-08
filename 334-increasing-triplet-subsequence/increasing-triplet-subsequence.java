class Solution {
    public boolean increasingTriplet(int[] nums) {
      List<Integer> l=new ArrayList<>();
      for(var s:nums){
        int idx=Collections.binarySearch(l,s);
        if(idx<0){
            idx=-(idx+1);
        }
        if(idx==l.size())l.add(s);
        else l.set(idx,s);
        if(l.size()==3)return true;
      }  
      return false;
    }
}