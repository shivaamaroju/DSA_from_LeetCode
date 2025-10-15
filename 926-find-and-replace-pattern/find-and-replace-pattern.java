class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for(var i : words)
            if(check(i,pattern))
                res.add(i);
        return res;
    }
    boolean check(String s,String t){
        Map<Character,Character> mp = new HashMap<>();
        if(s.length() != t.length())
            return false;
        for(var i  = 0 ; i < s.length(); i++){
            char ch = s.charAt(i);
            char chh = t.charAt(i);
            if(!mp.containsKey(ch))
                mp.put(ch,chh);
            else if(mp.get(ch) != chh)
                return false;
        }
        Set<Character> st = new HashSet<>();
        for(var i : t.toCharArray())
            st.add(i);
        return mp.size() == st.size();
    }
}