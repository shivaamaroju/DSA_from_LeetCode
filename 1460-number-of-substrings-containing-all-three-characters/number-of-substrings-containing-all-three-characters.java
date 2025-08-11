class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] count = new int[3]; // count[0] for 'a', count[1] for 'b', count[2] for 'c'
        int st = 0;
        int result = 0;

        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;

            // shrink window until it no longer contains all three
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                result += n - i; // all substrings from st to end are valid
                count[s.charAt(st) - 'a']--;
                st++;
            }
        }
        return result;
    }
}
