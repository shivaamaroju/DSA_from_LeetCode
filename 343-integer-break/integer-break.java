import java.util.*;

class Solution {
    public int integerBreak(int n) {
        HashMap<String, Integer> dp = new HashMap<>();
        return helper(0, 1, n, 1, dp);
    }

    public int helper(int sum, int idx, int n, int p, HashMap<String, Integer> dp) {
        if (sum > n) return Integer.MIN_VALUE;
        if (sum == n) return p;

        // Unique key for memoization
        String key = sum + "," + p;
        if (dp.containsKey(key)) return dp.get(key);

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (sum == 0 && i == n) continue;  // must break at least once
            sum += i;
            int x = helper(sum, i, n, p * i, dp);
            if (x != Integer.MIN_VALUE)
                ans = Math.max(ans, x);
            sum -= i;
        }

        dp.put(key, ans);
        return ans;
    }
}
