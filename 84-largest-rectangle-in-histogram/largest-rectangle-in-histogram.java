class Solution {
    public int largestRectangleArea(int[] h) {
        int pge[]=new int[h.length];
        int nge[]=new int[h.length];
        Stack<Integer> st=new Stack<>();
        Arrays.fill(nge,h.length);
        Arrays.fill(pge,-1);

        for(int i=0;i<h.length;i++){
            while(!st.isEmpty()&&h[st.peek()]>h[i]){
                nge[st.pop()]=i;
            }
            st.push(i);
        }
        st=new Stack<>();
 for(int i=h.length-1;i>=0;i--){
            while(!st.isEmpty()&&h[st.peek()]>h[i]){
                pge[st.pop()]=i;
            }
            st.push(i);
        }
        int max=0;
        for(int i=0;i<h.length;i++){
    int width=(nge[i]-pge[i]-1);
    max=Math.max(max,h[i]*width);
        }
        return max;




    }
}