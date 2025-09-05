class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for (int k = 1; k <= 60; k++) { 
            long val = (long) num1 - (long) k * num2;
            if (val < 0) continue;
            if (Long.bitCount(val) <= k && k <= val) {
                return k;
            }
        }
        return -1;
    }
}
