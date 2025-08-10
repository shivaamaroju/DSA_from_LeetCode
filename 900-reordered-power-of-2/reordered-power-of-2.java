class Solution {
    public boolean reorderedPowerOf2(int n) {
        int x = (int) Math.floor(Math.log10(n)) + 1;
        int a[] = new int[x];
        for (int i = a.length - 1; i >= 0; i--) {
            a[i] = n % 10;
            n = n / 10;
        }

        int count = 0;
        int totalPerms = fact(a.length);
        while (count < totalPerms) {
            if (pow2(a)) return true;
            nextprem(a);
            count++;
        }
        return false;
    }

    public void nextprem(int nums[]) {
        int idx = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            reverse(nums, 0, nums.length - 1);
        } else {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[idx] < nums[i]) {
                    int temp = nums[idx];
                    nums[idx] = nums[i];
                    nums[i] = temp;
                    break;
                }
            }
            reverse(nums, idx + 1, nums.length - 1);
        }
    }

    public void reverse(int nums[], int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

    public boolean pow2(int[] nums) {
        if (nums[0] == 0) return false;
        int num = 0;
        for (int d : nums) {
            num = num * 10 + d;
        }
        return (num & (num - 1)) == 0;
    }

    public int fact(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) res *= i;
        return res;
    }
}
