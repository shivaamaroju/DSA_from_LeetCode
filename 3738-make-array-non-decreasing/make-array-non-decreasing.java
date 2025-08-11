class Solution {
    public int maximumPossibleSize(int[] nums) {
        int c=0;
        Stack<Integer> st=new Stack<>();
        for(var s:nums){
            int cur=s;
            while(!st.isEmpty()&&st.peek()>cur){
                cur=Math.max(cur,st.pop());
            }
            st.push(cur);
        }
        return st.size();
    }
}