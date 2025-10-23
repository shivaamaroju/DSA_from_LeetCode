class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> mp=new HashMap<>();
        boolean f=true;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(mp.containsKey(ch)){
                int k=mp.get(ch);
                mp.put(ch,k+1);
            }
            else{
                mp.put(ch,1);
            }
        }
    
        int sum=0,ss=0;
        for(var m: mp.entrySet()){
            if(m.getValue()%2==0)
            {
                sum+=m.getValue();
            }
       
            else{
              
                sum+=m.getValue()-1;
                f=false;

            }

        }
       if(!f)sum+=1;
        return sum;
    }
}