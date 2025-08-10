class Solution {
    public List<Integer> lexicalOrder(int n) {
      List<Integer> l=new ArrayList<>();
      while(n>0)l.add(n--);
      l.sort((x,y)->{
        String  dx=""+x;
        String dy=""+y;
        return dx.compareTo(dy);
      });
      return l;
    }
}