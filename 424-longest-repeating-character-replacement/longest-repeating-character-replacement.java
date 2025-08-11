class Solution {
    public int characterReplacement(String s, int k) {
        int st=0;
        HashMap<Character,Integer> mp=new HashMap<>();
        int maxfreq=0,max=0;
        for(int i=0;i<s.length();i++){
char ch=s.charAt(i);
mp.put(ch,mp.getOrDefault(ch,0)+1);
maxfreq=Math.max(maxfreq,mp.get(ch));
while((i-st+1)-maxfreq>k){
    char dh=s.charAt(st);
    st++;
    mp.put(dh,mp.get(dh)-1);
}
max=Math.max((i-st+1),max);
        }
        return max;
    }
}