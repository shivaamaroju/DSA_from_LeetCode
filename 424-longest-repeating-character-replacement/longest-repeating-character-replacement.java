class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        int st=0,max=0,maxfreq=0;
        for(int i=0;i<s.length();i++){
            int x=s.charAt(i)-'A';
            mp.put(x,mp.getOrDefault(x,0)+1);
            maxfreq=Math.max(maxfreq,mp.get(x));
            while((i-st+1)-maxfreq>k){
                int xy=s.charAt(st)-'A';
                st++;
                mp.put(xy,mp.getOrDefault(xy,0)-1);
            }
            max=Math.max(max,i-st+1);
        }
        return max;
    }
}