class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int maxReach = Math.max(startPos + k, fruits[fruits.length - 1][0]);
        int[] Actual = new int[maxReach + 1];
        Map<Integer, Integer> mp = new HashMap<>();

        for (int[] fruit : fruits) {
            mp.put(fruit[0], fruit[1]);
        }

        for (int i = 0; i <= maxReach; i++) {
            if (mp.containsKey(i)) {
                Actual[i] = mp.get(i);
            }
        }

        int[] prefix = new int[Actual.length];
        prefix[0] = Actual[0];
        for (int i = 1; i < Actual.length; i++) {
            prefix[i] = prefix[i - 1] + Actual[i];
        }

        int max = 0;

        for (int i = 0; i <= k; i++) {
            // Left i, right k - 2i
            int left = Math.max(0, startPos - i);
            int right = Math.min(prefix.length - 1, startPos + (k - 2 * i));
            if (left <= right) {
                int sum1 = prefix[right] - (left > 0 ? prefix[left - 1] : 0);
                max = Math.max(max, sum1);
            }

            // Right i, left k - 2i
            right = Math.min(prefix.length - 1, startPos + i);
            left = Math.max(0, startPos - (k - 2 * i));
            if (left <= right) {
                int sum2 = prefix[right] - (left > 0 ? prefix[left - 1] : 0);
                max = Math.max(max, sum2);
            }
        }

        return max;
    }
}
