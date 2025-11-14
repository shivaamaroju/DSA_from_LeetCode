class Solution {
    public int longestValidParentheses(String s) {
        int c=0,ob=0,cb=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(')ob++;
            else cb++;
            if(ob==cb)c=Math.max(c,cb+ob);
            else if(ob<cb){
                cb=0;ob=0;
            }
        }
        cb=0;ob=0;
        for(int i=s.length()-1;i>=0;i--){
            char ch=s.charAt(i);
            if(ch=='(')ob++;
            else cb++;
            if(ob==cb)c=Math.max(c,cb+ob);
           else if(ob>cb){
                cb=0;ob=0;
            }
        }
        return c;
    }
}