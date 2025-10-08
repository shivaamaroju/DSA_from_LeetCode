class MinStack {
Stack<Integer> st;
Stack<Integer> min;
// Stack<Integer> st;
    public MinStack() {
       st=new Stack<>(); 
       min=new Stack<>(); 
    }
    
    public void push(int val) {
        st.push(val);
        if(min.size()==0)min.push(val);
        else min.push(Math.min(min.peek(),val));
    }
    
    public void pop() {
        st.pop();
        min.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */