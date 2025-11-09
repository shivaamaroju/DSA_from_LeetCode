import java.util.*;

class Solution {
    HashMap<String, Integer> mp = new HashMap<>();

    public int countOperations(int n, int m) {
        return helper(n, m);
    }

    private int helper(int n, int m) {
        // Base cases
        if (n == 0 || m == 0) return 0;

        String key = n + "," + m;
        if (mp.containsKey(key)) return mp.get(key);

        int ans;
        if (n >= m)
            ans = 1 + helper(n - m, m);
        else
            ans = 1 + helper(n, m - n);

        mp.put(key, ans);
        return ans;
    }
}
