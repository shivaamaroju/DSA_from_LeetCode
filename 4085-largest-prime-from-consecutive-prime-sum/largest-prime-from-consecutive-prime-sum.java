class Solution {
    public int largestPrime(int n) {
        if (n < 2) return 0;
        boolean isNotPrime[] = new boolean[n + 1];
        isNotPrime[0] = isNotPrime[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        int sum = 0;
        int ans = 0;

        for (int i = 2; i <= n; i++) {
            if (!isNotPrime[i]) {
                sum += i;
                if (sum > n) break; 
                if (!isNotPrime[sum]) ans = sum; 
            }
        }

        return ans;
    }
}
