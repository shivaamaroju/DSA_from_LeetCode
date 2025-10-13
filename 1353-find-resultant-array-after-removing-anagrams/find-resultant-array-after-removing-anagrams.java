class Solution {
    public List<String> removeAnagrams(String[] words) {
        Stack<String> st=new Stack<>();
        for(var s: words){
            if(st.isEmpty()){
                st.push(s);
                continue;}
                char ch[]=st.peek().toCharArray();
                Arrays.sort(ch);
                char ch2[]=s.toCharArray();
                Arrays.sort(ch2);
                String a=new String(ch);
                String b=new String(ch2);


            if(a.equals(b))continue;
             st.push(s);
        }
        List<String> ans=new ArrayList<>();
        while(st.size()>0){
            ans.add(0,st.pop());
        }
        return ans;
    }
}