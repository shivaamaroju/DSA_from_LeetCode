class Solution {
    public boolean pyramidTransition(String bottom, List<String> a) {
        HashMap<Pair,List<Character>>mp=new HashMap<>();
        for(var s:a){
            mp.computeIfAbsent(new Pair(s.charAt(0),s.charAt(1)),k->new ArrayList<>()).add(s.charAt(2));
        }
        return helper(bottom,mp);
    }
    public boolean helper(String s,HashMap<Pair,List<Character>>mp){
if(s.length()==1)return true;

return generate(s,0,new StringBuffer(),mp);
    }
    public boolean generate(String s,int idx,StringBuffer sb,HashMap<Pair,List<Character>>mp){
        if(idx==s.length()-1)return helper(sb.toString(),mp);
        Pair p=new Pair(s.charAt(idx),s.charAt(idx+1));
        if(!mp.containsKey(p))return false;
        for(var ss:mp.get(p)){
            sb.append(ss);
            if(generate(s,idx+1,sb,mp))return true;
            sb.deleteCharAt(sb.length()-1);
        }
        return false;

    }
}