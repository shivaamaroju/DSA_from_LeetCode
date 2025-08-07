class Solution {
    public String longestPalindrome(String s) {
        String ans="";
        for(int i=0;i<s.length();i++){
            String ss=pal(s,i,i);
            String sss=pal(s,i,i+1);
            if(ss.length()>ans.length())ans=ss;
            if(sss.length()>ans.length())ans=sss;
        }
        return ans;
    }
    public String pal(String s,int i,int j){
        int st=0,end=0;
        while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
            st=i--;
            end=j++;
        }
        return s.substring(st,end+1);
    }
}