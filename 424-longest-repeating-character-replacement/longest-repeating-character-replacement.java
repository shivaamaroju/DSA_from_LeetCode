class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer>mp=new HashMap<>();
        int st=0,maxfreq=0,max=0;
 for(int i=0;i<s.length();i++){
char ch=s.charAt(i);
mp.put(ch,mp.getOrDefault(ch,0)+1);
maxfreq=Math.max(maxfreq,mp.get(ch));
while((i-st+1)-maxfreq>k){
    char chh=s.charAt(st++);
    mp.put(chh,mp.getOrDefault(chh,0)-1);
}
max=Math.max(max,i-st+1);


        }
        return max;
    }
}