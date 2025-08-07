class Solution {
int c=0;
    public int countSubstrings(String s) {
        for(int i=0;i<s.length();i++){
            String ss=pal(s,i,i);
            String sss=pal(s,i,i+1);
           
        }
        return c;
    }
    public String pal(String s ,int i,int j){
        int st=0,ed=0;
        while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
            st=i--;
            ed=j++;
           c++;
        }
        return s.substring(st,ed+1);
    }
}