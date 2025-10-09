class Solution {
    public int maxSumMinProduct(int[] nums) {
      int mod=(int)1e9+7;
      int n=nums.length;
      long p[]=new long[n+1];
      int nge[]=new int[n];
      int pse[]=new int[n];
      Arrays.fill(nge,n);
      Arrays.fill(pse,-1);
      for(int i=0;i<n;i++){
p[i+1]=nums[i]+p[i];
      }
      Stack<Integer> st=new Stack<>();
    for(int i=0;i<n;i++){
        while(st.size()>0&&nums[st.peek()]>nums[i])nge[st.pop()]=i;
        st.push(i);
    }
     st=new Stack<>();
    for(int i=n-1;i>=0;i--){
        while(st.size()>0&&nums[st.peek()]>nums[i])pse[st.pop()]=i;
        st.push(i);
    }
    long max=0;
    for(int i=0;i<n;i++){
        int r=nge[i]-1;
        int l=pse[i]+1;
        long sum=p[r+1]-p[l];
        max=Math.max(sum*nums[i],max);
    }
    return (int)(max%mod);

    }
}