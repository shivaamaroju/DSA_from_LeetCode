class Solution {
    public int[] dailyTemperatures(int[] b) {
        int n=b.length;
        int a[]=new int[n];
        Arrays.fill(a,0);
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<a.length;i++){
while(!st.isEmpty()&&b[i]>b[st.peek()]){
    a[st.peek()]=i;
    st.pop();
}

st.push(i);
        }
        for(int i=0;i<n;i++){
            a[i]=a[i]-i;
            if(a[i]<0)a[i]=0;
        }
        return a;
    }
}