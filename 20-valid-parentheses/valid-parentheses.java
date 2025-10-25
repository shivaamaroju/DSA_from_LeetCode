class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(var ch : s.toCharArray()){
            if("[{(".contains(ch+""))
                st.push(ch);
            else{
                if(st.isEmpty())
                    return false;
                char p=st.pop();
                if((ch=='}'&& p!='{')||(ch==']'&& p!='[')||(ch==')'&& p!='('))
                    return false;
            }
        }

        return st.isEmpty();   
    }
}