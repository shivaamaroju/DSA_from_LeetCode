class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int nse[]=new int[n];
        int pse[]=new int[n];
        Arrays.fill(nse,n);
        Arrays.fill(pse,-1);
        Stack<Integer> st=new Stack<>();
    for(int i=0;i<n;i++){
        while(st.size()>0&&heights[st.peek()]>heights[i]){
nse[st.pop()]=i;
        }
        st.push(i);
    }
     st=new Stack<>();
    for(int i=n-1;i>=0;i--){
        while(st.size()>0&&heights[st.peek()]>heights[i]){
pse[st.pop()]=i;
        }
        st.push(i);
    }
    int max=0;
   for(int i=0;i<n;i++){
    int w=nse[i]-pse[i]-1;
    max=Math.max(max,w*heights[i]);
   }
    return max;
    }
}