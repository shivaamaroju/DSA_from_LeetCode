class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (s.charAt(0) == '0') return 0;

        int[] dp = new int[n + 1];
        dp[0] = 1; // empty string
        dp[1] = 1; // first char already checked not zero

        for (int i = 2; i <= n; i++) {
            // 1-digit
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            // 2-digit
            int two = Integer.parseInt(s.substring(i - 2, i));
            if (two >= 10 && two <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
