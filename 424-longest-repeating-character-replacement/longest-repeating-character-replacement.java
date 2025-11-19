class Solution {
    public int characterReplacement(String s, int k) {
        int maxfreq=0,max=0,st=0;
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<s.length();i++){
            int ch=s.charAt(i)-'A';
            mp.put(ch,mp.getOrDefault(ch,0)+1);
            maxfreq=Math.max(mp.get(ch),maxfreq);
            while(((i-st+1)-maxfreq)>k){
                int chc=s.charAt(st++)-'A';
                mp.put(chc,mp.getOrDefault(chc,0)-1);

            }
            max=Math.max(max,(i-st+1));
        }
        return max;
    }
}