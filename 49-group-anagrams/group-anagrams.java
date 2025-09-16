class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> mp=new HashMap<>();
        for(var s:strs){
            char ch[]=s.toCharArray();
            Arrays.sort(ch);
            String t=new String(ch);
            if(mp.containsKey(t)){
                mp.get(t).add(s);
            }
            else{
                List<String> l=new ArrayList<>();
l.add(s);
                mp.put(t,l);
            }
        }
        List<List<String>> ll=new ArrayList<>();
        for(var s:mp.entrySet())ll.add(s.getValue());
        return ll;
   
}}