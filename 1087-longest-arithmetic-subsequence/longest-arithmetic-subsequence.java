class Solution {
    HashMap<String, Integer> mp = new HashMap<>();

    public int longestArithSeqLength(int[] nums) {
        int max = 0;
        int n = nums.length;
        Map<Integer,Integer> [] dp = new HashMap[n];
        int ans =2;

        for(int i=0;i<n;i++){
            dp[i]  = new HashMap<>();
            for(int j=0;j<i;j++){

                int diff = nums[j]-nums[i];
                 dp[i].put(diff,dp[j].getOrDefault(diff,1)+1);
                 int maxLen  = dp[i].get(diff);
                // dp[j].put(nums[i],maxLen);
                ans = Math.max(ans,maxLen);



            }
        }
        return ans;


        // for (int i = 0; i < n; i++) {

        //     for (int j = i + 1; j < n; j++) {

        //         int diff = nums[j] - nums[i];

        //         int len = 2 + helper(nums[j], j + 1, diff, nums);

        //         max = Math.max(max, len);
        //     }
        // }
        // return max;
    }

    public int helper(int ele, int idx, int diff, int nums[]) {

        if (idx >= nums.length) return 0;

        String key = ele + "#" + idx + "#" + diff;

        if (mp.containsKey(key)) return mp.get(key);

        int best = 0;

        if (nums[idx] - ele == diff) {
            best = 1 + helper(nums[idx], idx + 1, diff, nums);
        } else {
            best = helper(ele, idx + 1, diff, nums);
        }

        mp.put(key, best);
        return best;
    }
}
