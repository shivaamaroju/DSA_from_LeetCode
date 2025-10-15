class Solution {
   public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
    for (int i = 0; i + 2 * k <= nums.size(); i++) {
        int c1 = 1; // first increasing subarray length counter
        int c2 = 1; // second increasing subarray length counter
        
        // Check first subarray of length k
        for (int j = i; j < i + k - 1; j++) {
            if (nums.get(j) < nums.get(j + 1)) c1++;
            else break; // must be strictly increasing
        }

        // Check second subarray of length k
        for (int j = i + k; j < i + 2 * k - 1; j++) {
            if (nums.get(j) < nums.get(j + 1)) c2++;
            else break;
        }

        if (c1 == k && c2 == k) return true;
    }
    return false;
}
}