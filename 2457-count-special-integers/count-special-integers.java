class Solution {
    int a[];

    Solution() {
        a = new int[11];
        a[0] = 1;
        for (int i = 1; i <= 10; i++) a[i] = a[i - 1] * i;
    }

    public int countSpecialNumbers(int n) {
        String s = "" + n;
        int len = s.length();
        int sum = 0;

        // count all numbers with digits < len
        for (int d = 1; d < len; d++) {
            int res = 9;
            int choices = 9;
            for (int k = 1; k < d; k++) {
                res *= choices;
                choices--;
            }
            sum += res;
        }

        HashSet<Integer> used = new HashSet<>();
        int available = 9;

        for (int i = 0; i < len; i++) {
            int curr = s.charAt(i) - '0';

            int countSmaller = 0;
            for (int d = 0; d < curr; d++) {
                if (i == 0 && d == 0) continue;
                if (!used.contains(d)) countSmaller++;
            }

            int rem = len - i - 1;

            if (rem == 0) sum += countSmaller;
            else sum += countSmaller * (a[available] / a[available - rem]);

            if (used.contains(curr)) return sum;
            used.add(curr);
            available--;
        }

        return sum + 1;
    }
}
