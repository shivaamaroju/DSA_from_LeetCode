import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] a) {
        Arrays.sort(a, (x, y) -> {
            if (x[0] == y[0]) return x[1] - y[1];
            return x[0] - y[0];
        });

        int prev = a[0][1];
        int c = 0;

        for (int i = 1; i < a.length; i++) {
            if (a[i][0] >= prev) {
                prev = a[i][1];
            } else {
                c++;
                prev = Math.min(prev, a[i][1]);
            }
        }
        return c;
    }
}
