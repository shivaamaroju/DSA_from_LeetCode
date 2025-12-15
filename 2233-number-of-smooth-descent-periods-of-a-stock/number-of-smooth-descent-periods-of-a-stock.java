class Solution {
    public long getDescentPeriods(int[] prices) {
        long sum = 1;  
        long len = 1;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] - prices[i] == 1) {
                len++;
            } else {
                len = 1;
            }
            sum += len;
        }
        return sum;
    }
}
