class Solution {
    public int longestOnes(int[] nums, int k) {
        int st = 0, zeroCount = 0, maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zeroCount++;

            while (zeroCount > k) {
                if (nums[st] == 0) zeroCount--;
                st++;
            }

            maxLen = Math.max(maxLen, i - st + 1);
        }

        return maxLen;
    }
}
