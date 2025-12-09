class Solution {
    public int specialTriplets(int[] nums) {
        HashMap<Integer,Integer> right = new HashMap<>();
        HashMap<Integer,Integer> left  = new HashMap<>();

        for (int s : nums)
            right.put(s, right.getOrDefault(s,0) + 1);

        long c = 0, mod = 1_000_000_007;

        for (int s : nums) {
            right.put(s, right.get(s) - 1);

                int half = s * 2;

                long leftCnt  = left.getOrDefault(half,0);
                long rightCnt = right.getOrDefault(half,0);

                c = (c + (leftCnt * rightCnt) % mod) % mod;
            
            left.put(s, left.getOrDefault(s,0) + 1);
        }
        return (int)c;
    }
}
