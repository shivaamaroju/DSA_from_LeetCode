class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> mp=new HashMap<>();
        for(var ch:t.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        int ws=-1,we=-1,min=Integer.MAX_VALUE;
        int stillneed=mp.size();
        int st=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(mp.containsKey(ch)){
                mp.put(ch,mp.get(ch)-1);
                if(mp.get(ch)==0)stillneed--;
                if(stillneed==0){
                    if(i-st+1<min){
                        ws=st;
                        we=i;
                        min=i-st+1;
                    }
                    while(st<=i){
                        char dh=s.charAt(st++);
                        if(mp.containsKey(dh)){
                            mp.put(dh,mp.get(dh)+1);
                            if(mp.get(dh)==1){
                                stillneed++;
                                if(i-st+2<min){
                                    ws=st-1;
                                    we=i;
                                    min=i-st+2;
                                }
                                break;
                            }

                        }
                    }
                }
            }
        }
        if(we==-1||ws==-1)return "";
        return s.substring(ws,we+1);
    }
}