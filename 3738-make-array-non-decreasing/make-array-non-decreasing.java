class Solution {
    public int maximumPossibleSize(int[] nums) {
     Stack<Integer> st=new Stack<>();
     for(var s:nums){
        int cur =s;
        while(!st.isEmpty()&&st.peek()>cur){
            cur=Math.max(st.pop(),cur);
        }
        st.push(cur);
     }
     return st.size();
    }
}