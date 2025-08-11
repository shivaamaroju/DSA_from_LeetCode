class Solution {
    public int trap(int[] height) {
        int n=height.length;
      int pge[]=new int[n];
      int nge[]=new int[n];
      Stack<Integer> st=new Stack<>();
      for(int i=n-1;i>=0;i--){
        while(!st.isEmpty()&&height[i]>=height[st.peek()]){
            st.pop();
        }
        if(st.isEmpty())pge[i]=height[i];
        else pge[i]=Math.max(height[i],pge[st.peek()]);
        st.push(i);
      }  



      st=new Stack<>();
     for(int i=0;i<n;i++){
        while(!st.isEmpty()&&height[i]>=height[st.peek()]){
            st.pop();
        }
        if(st.isEmpty())nge[i]=height[i];
        else nge[i]=Math.max(height[i],nge[st.peek()]);
        st.push(i);
      }  
      int water=0;
      for(int i=0;i<n;i++){
        int max=Math.min(nge[i],pge[i])-height[i];
        if(max>0)water+=max;
      }
      return water;
    }
}