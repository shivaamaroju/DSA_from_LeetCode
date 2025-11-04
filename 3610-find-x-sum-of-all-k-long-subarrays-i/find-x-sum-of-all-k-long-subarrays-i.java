class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int ans[]=new int[nums.length-k+1];
        for(int i=0;i<nums.length-k+1;i++){
            HashMap<Integer,Integer> mp=new HashMap<>();
            int sum1=0;
            for(int j=i;j<=i+k-1;j++){
                mp.put(nums[j],mp.getOrDefault(nums[j],0)+1);
                sum1+=nums[j];
            }
            if(mp.size()<x)ans[i]=sum1;
            else{
            PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
               if(mp.get(b)==mp.get(a)) return b-a;
               return mp.get(b)-mp.get(a);
                });
                
        int sum=0;
            for(var s:mp.entrySet()){
pq.add(s.getKey());
            }
            int y=x;
        while(pq.size()>0&&y>0){
            int ele=pq.remove();
            sum+=(ele*mp.get(ele));
            y--;
        }
        ans[i]=sum;
            }
        }
        return ans;
    }
}