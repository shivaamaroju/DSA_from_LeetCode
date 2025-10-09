class Solution {
    public int findMinArrowShots(int[][] a) {
        if(a.length==0)return 0;
        Arrays.sort(a,(x,y)-> Integer.compare(x[1],y[1]));
        List<List<Integer>> l=new ArrayList<>();
        for(var s:a){
            if(l.size()>0&&l.get(l.size()-1).get(1)>=s[0]){
               l.get(l.size()-1).set(1,Math.min(s[1],l.get(l.size()-1).get(1)));
               }
                else{
 List<Integer> ll=new ArrayList<>();
                ll.add(s[0]);
                ll.add(s[1]);
                l.add(ll);
                }

        }
        return l.size();

    }
}