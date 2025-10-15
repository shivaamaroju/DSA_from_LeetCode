import java.util.*;

class Solution {

    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int low = 1, high = n / 2;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2; 
            if (hasIncreasingSubarrays(nums, mid)) {
                ans = mid;      
                low = mid + 1;
            } else {
                high = mid - 1; 
            }
        }

        return ans;
    }

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        for (int i = 0; i + 2 * k <= n; i++) {
            boolean ok1 = true, ok2 = true;

            // check first subarray
            for (int j = i; j < i + k - 1; j++) {
                if (nums.get(j) >= nums.get(j + 1)) {
                    ok1 = false;
                    break;
                }
            }

            // check second subarray
            for (int j = i + k; j < i + 2 * k - 1; j++) {
                if (nums.get(j) >= nums.get(j + 1)) {
                    ok2 = false;
                    break;
                }
            }

            if (ok1 && ok2) return true;
        }
        return false;
    }

    
}
