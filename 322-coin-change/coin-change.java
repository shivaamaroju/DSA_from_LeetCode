class Solution {
    int c = Integer.MAX_VALUE;
    List<Integer> l = new ArrayList<>();
    int[][] dp; // memo
    
    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length][amount + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        
        int minCoins = helper(coins, amount, 0);
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }
    
    public int helper(int a[], int t, int idx) {
        if (t < 0 || idx >= a.length) return Integer.MAX_VALUE;
        if (dp[idx][t] != -1) return dp[idx][t];
        if (t == 0) return 0; // no more coins needed
        
        int min = Integer.MAX_VALUE;
        for (int i = idx; i < a.length; i++) {
            int res = helper(a, t - a[i], i);
            if (res != Integer.MAX_VALUE) {
                min = Math.min(min, res + 1); // +1 for current coin
            }
        }
        
        return dp[idx][t] = min;
    }
}
