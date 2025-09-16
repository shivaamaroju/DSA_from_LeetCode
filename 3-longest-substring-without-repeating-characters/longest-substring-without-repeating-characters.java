class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0,st=0;
        HashMap<Character,Integer> mp=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
            while(mp.get(ch)>=2&&st<=i){
                char cc=s.charAt(st);
                st++;
                if(mp.get(cc)==1)mp.remove(cc);
                else mp.put(cc,mp.get(cc)-1);
                            }
                            max=Math.max(max,mp.size());
        }
        return max;

    }
}