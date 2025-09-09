class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> outer=new ArrayList<>();
        for(int i=0;i<searchWord.length();i++){
            String s=searchWord.substring(0,i+1);
            List<String> inner=new ArrayList<>();
            for(var j:products){
                if(j.startsWith(s)) inner.add(j);
            }
            Collections.sort(inner,(a,b)-> a.compareTo(b));
           if(inner.size()>=3) outer.add(inner.subList(0,3));
           else outer.add(inner);
        }
        return outer;
    }
}