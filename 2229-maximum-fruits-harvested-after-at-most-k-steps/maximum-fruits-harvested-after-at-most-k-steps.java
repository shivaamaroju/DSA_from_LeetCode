class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        // Find last fruit position to size the array
        int last = fruits[fruits.length - 1][0];
        int[] actual = new int[Math.max(last, startPos) + k + 2];

        // Fill in the actual fruit count at each position
        for (int[] fruit : fruits) {
            actual[fruit[0]] = fruit[1];
        }

        // Build prefix sum for fast range queries
        for (int i = 1; i < actual.length; i++) {
            actual[i] += actual[i - 1];
        }

        int max = 0;

        // Move left first (i steps left, then j steps right)
        for (int x = 0; x <= k / 2; x++) {
            int left = startPos - x;
            int right = Math.min(startPos + (k - 2 * x), actual.length - 1);
            int total = actual[right] - (left > 0 ? actual[left - 1] : 0);
            max = Math.max(max, total);
        }

        // Move right first (i steps right, then j steps left)
        for (int x = 0; x <= k / 2; x++) {
            int right = startPos + x;
            int left = Math.max(0, startPos - (k - 2 * x));
            int total = actual[right] - (left > 0 ? actual[left - 1] : 0);
            max = Math.max(max, total);
        }

        return max;
    }
}
