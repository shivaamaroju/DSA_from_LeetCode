class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        int st=0;
        HashMap<Character,Integer> mp=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
            while(mp.get(ch)>=2){
              char ch2=s.charAt(st);
              System.out.println(ch2);
int x=mp.get(ch2);
if(x==1)mp.remove(ch2);
else
mp.put(ch2,x-1);st++;
            }
            //   System.out.println(mp        
            max=Math.max(max,mp.size());
        }
        return max;
    }
}