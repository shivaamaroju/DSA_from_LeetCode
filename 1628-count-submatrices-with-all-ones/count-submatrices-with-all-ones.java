class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int res = 0;
        int[][] row = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    row[i][j] = 0;
                } else {
                    row[i][j] = (j == 0) ? 1 : row[i][j - 1] + 1;

                    int minWidth = row[i][j];
                    for (int k = i; k >= 0 && row[k][j] > 0; k--) {
                        minWidth = Math.min(minWidth, row[k][j]);
                        res += minWidth;
                    }
                }
            }
        }
        return res;
    }
}
