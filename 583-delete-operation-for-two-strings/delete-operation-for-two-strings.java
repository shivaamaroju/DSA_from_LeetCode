class Solution {
    public int minDistance(String s1, String s2) {
    int[][] dp = new int[s1.length()][s2.length()];
        for (int[] row : dp) Arrays.fill(row, -1);
   return helper(s1, s2, s1.length() - 1, s2.length() - 1, dp);
    }

    public static int helper(String s, String t, int i, int j, int[][] dp) {
        if (i < 0 && j < 0) return 0;
        if (i < 0) {
           
            return j+1;
        }
        if (j < 0) {
           
            return i+1;
        }
        if (dp[i][j] != -1) return dp[i][j];
        if (s.charAt(i) == t.charAt(j)) return dp[i][j] = helper(s, t, i - 1, j - 1, dp);
        int deleteFromS = 1 + helper(s, t, i - 1, j, dp);
        int deleteFromT = 1 + helper(s, t, i, j - 1, dp);
        return dp[i][j] = Math.min(deleteFromS, deleteFromT);
    }}