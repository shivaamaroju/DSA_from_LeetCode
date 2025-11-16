class Solution {
    public int numSub(String s) {
        int oc = 0;
        long c = 0;
        long MOD = 1000000007;

        for(int i = 0; i < s.length(); i++){
            int x = s.charAt(i) - '0';

            if(x == 0){
                // FIXED: compute c*(c+1)/2 BEFORE modulo
                long val = (c * (c + 1)) / 2;
                oc = (int)((oc + (val % MOD)) % MOD);

                c = 0;   // reset counter of consecutive 1s
            }
            else{
                c++;
            }
        }

        // Final block outside loop
        long val = (c * (c + 1)) / 2;
        oc = (int)((oc + (val % MOD)) % MOD);

        return oc;
    }
}
