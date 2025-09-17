class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer>mp=new HashMap<>();
        int min=Integer.MAX_VALUE,ws=-1,st=0;
        for(var ss : t.toCharArray()){
            mp.put(ss,mp.getOrDefault(ss,0)+1);
        }
        int stillneed=t.length();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(mp.containsKey(ch)){
             if(mp.get(ch)>0)stillneed--;
             mp.put(ch,mp.get(ch)-1); 
            }
            while(stillneed==0&&st<=i){
                if(i-st+1<min){
                    min=i-st+1;
                    ws=st;
                }
                char ch2=s.charAt(st);
                st++;
if(mp.containsKey(ch2)){
    mp.put(ch2,mp.get(ch2)+1);
    if(mp.get(ch2)>0)stillneed++;
}
            }
        }

        if(ws==-1)return "";
        return s.substring(ws,ws+min);
    }
}