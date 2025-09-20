import java.util.*;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;

        Arrays.sort(points, (x, y) -> Integer.compare(x[1], y[1]));

        List<List<Integer>> l = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        ll.add(points[0][0]);
        ll.add(points[0][1]);
        l.add(ll);

        for(int i = 1; i < points.length; i++){
            if(l.get(l.size()-1).get(1) >= points[i][0]){
                l.get(l.size()-1).set(1, Math.min(l.get(l.size()-1).get(1), points[i][1]));
            } else {
                List<Integer> lll = new ArrayList<>();
                lll.add(points[i][0]);
                lll.add(points[i][1]);
                l.add(lll);
            }
        }

        return l.size();
    }
}
