class Solution {
    public int numSub(String s) {
        long c=0;
        long oc=0;
        for(int i=0;i<s.length();i++){
            int  x=s.charAt(i)-'0';
            if(x==0){
                c=0;
            }
            else{
                c++;
                oc+=c;
            }

        }
              
                return (int)(oc%((int)1e9+7));

    }
}