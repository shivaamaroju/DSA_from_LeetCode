class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;  // primes less than 2 don't exist except 2 itself
        
        boolean[] a = new boolean[n]; // only mark up to n-1
        a[0] = true;
        a[1] = true;

        for (int i = 2; i * i < n; i++) {
            if (!a[i]) {
                for (int j = i * i; j < n; j += i) { // start at i*i for optimization
                    a[j] = true;
                }
            }
        }

        int c = 0;
        for (boolean isComposite : a) {
            if (!isComposite) c++;
        }
        return c;
    }
}
