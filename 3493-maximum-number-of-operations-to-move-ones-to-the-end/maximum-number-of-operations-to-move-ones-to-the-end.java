class Solution {
    public int maxOperations(String s) {
        char ch[] = s.toCharArray();
        int no = 0, nz = 0, sum = 0;

        for (int i = 0; i < s.length(); i++) {
            int n = ch[i] - '0';
            if (n == 0) {
                sum += no;
                while (i < ch.length && ch[i] == '0') i++;
                if (i > 0) {
                    ch[i - 1] = (char) ('0' + no);
                    no = ch[i - 1] - '0';
                }
                i--;
            } else {
                nz = 0;
                no += n;
            }
        }
        return sum;
    }
}
