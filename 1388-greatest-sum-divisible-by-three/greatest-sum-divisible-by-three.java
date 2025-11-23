class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum=0;
        List<Integer> l=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();
        for(var s:nums){
            sum+=s;
            if(s%3==1)l.add(s);
            if(s%3==2)l2.add(s);
        }
        Collections.sort(l);
        Collections.sort(l2);
        if(sum%3==0)return sum;
        int max=0;
        if(sum%3==1){
            if(l.size()>0)max=Math.max(max,sum-l.get(0));
            if(l2.size()>1)max=Math.max(max,sum-l2.get(0)-l2.get(1));
            return max;
        }
        else{
             if(l2.size()>0)max=Math.max(max,sum-l2.get(0));
            if(l.size()>1)max=Math.max(max,sum-l.get(0)-l.get(1));
            return max;
        }
        // return max;

    }
}