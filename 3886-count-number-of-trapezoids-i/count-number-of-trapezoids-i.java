class Solution {
    public int countTrapezoids(int[][] points) {
        final int MOD = 1_000_000_007;

        Map<Integer, Integer> yCount = new HashMap<>();
        for (int[] p : points) {
            yCount.put(p[1], yCount.getOrDefault(p[1], 0) + 1);
        }

        List<Long> cList = new ArrayList<>();
        for (int count : yCount.values()) {
            if (count >= 2) {
                long c = ((long) count * (count - 1)) / 2;
                cList.add(c);
            }
        }

        long totalSum = 0;
        for (long c : cList) totalSum += c;

        long result = 0;
        for (long c : cList) {
            totalSum -= c;
            result = (result + c * totalSum) % MOD;
        }

        return (int) result;
    }
}
