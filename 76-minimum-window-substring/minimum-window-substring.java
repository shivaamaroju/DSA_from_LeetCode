class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> mp=new HashMap<>();
        for(var ss:t.toCharArray()){
            mp.put(ss,mp.getOrDefault(ss,0)+1);
        }
        int still=t.length();
        int min=Integer.MAX_VALUE;
        int ws=-1;
        int st=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(mp.containsKey(ch)){
                if(mp.get(ch)>0)still--;
                mp.put(ch,mp.get(ch)-1);
            }
            while(still==0){
                if(i-st+1<min){
                    min=i-st+1;
                    ws=st;
                }
                char ch3=s.charAt(st);
                st++;
                if(mp.containsKey(ch3)){
                    mp.put(ch3,mp.get(ch3)+1);
                    if(mp.get(ch3)>0)still++;
                }
            }

        }
        if(ws==-1)return "";
        return s.substring(ws,ws+min);
    }
}