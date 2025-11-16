class Solution {
    public int countHomogenous(String s) {
        long c=1,sum=0;
        if(s.length()==1)return 1;
        char prev=s.charAt(0);
        for(int i=1;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==prev){
                c++;
            }
            else{
                c=1;
               
            }
             sum+=c;
                prev=ch;
        }
        return (int)((sum + 1) % 1000000007);

    }
}