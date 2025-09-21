class Solution {
    public int maxSumMinProduct(int[] nums) {
        int mod=(int)1e9+7;
        int n=nums.length;
        long ps[]=new long[n+1];
        for(int i=0;i<n;i++){
ps[i+1]=ps[i]+nums[i];
        }
        int pge[]=new int[n];
        int nge[]=new int[n];
        Stack<Integer> st=new Stack<>();
        Arrays.fill(nge,n);
        Arrays.fill(pge,-1);
        for(int i=0;i<n;i++){
while(st.size()>0&&nums[st.peek()]>nums[i]){
    nge[st.pop()]=i;
}
st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
while(st.size()>0&&nums[st.peek()]>nums[i]){
    pge[st.pop()]=i;
}
st.push(i);
        }
        st.clear();
        long max=0;
        for(int i=0;i<n;i++){
            int l=pge[i]+1;
            int r=nge[i]-1;
            long sum=ps[r+1]-ps[l];
            max=Math.max(max,sum*nums[i]);
        }
        return (int)(max%mod);
    
    }
}