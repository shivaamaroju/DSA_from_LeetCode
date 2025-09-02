class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            int ax = points[i][0], ay = points[i][1];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int bx = points[j][0], by = points[j][1];
                if (ax <= bx && ay >= by) {
                    if (isValid(points, i, j, ax, ay, bx, by)) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
    
    private boolean isValid(int[][] points, int ai, int bi, int ax, int ay, int bx, int by) {
        for (int k = 0; k < points.length; k++) {
            if (k == ai || k == bi) continue;
            int x = points[k][0], y = points[k][1];
            if (ax <= x && x <= bx && by <= y && y <= ay) {
                return false;
            }
        }
        return true;
    }
}
