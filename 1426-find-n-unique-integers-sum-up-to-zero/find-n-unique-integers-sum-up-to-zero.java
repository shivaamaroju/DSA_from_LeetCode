class Solution {
    public int[] sumZero(int n) {
        int k = n / 2;
        int a[] = new int[n];
        k = -k;

        if (n % 2 != 0) {
            // For odd n, populate with -k to k, where k starts as -(n//2)
            for (int i = 0; i < a.length; i++) {
                a[i] = k;
                k++;
            }
        } else {
            // For even n, avoid including 0, so populate from -k to k skipping 0
            int j = 0;
            for (int i = -n/2; i <= n/2; i++) {
                if (i != 0) {
                    a[j++] = i;
                }
            }
        }
        return a;
    }
}
