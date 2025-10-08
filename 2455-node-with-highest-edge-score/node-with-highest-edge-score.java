class Solution {
    public int edgeScore(int[] edges) {
        long[] a = new long[edges.length]; // use long to avoid overflow
        for (int i = 0; i < edges.length; i++) {
            a[edges[i]] += i;
        }

        long max = -1;
        int ans = -1;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
                ans = i;
            }
        }

        return ans;
    }
}
