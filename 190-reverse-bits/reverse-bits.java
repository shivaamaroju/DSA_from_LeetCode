class Solution {
    public int reverseBits(int n) {
       int ans=0;
       for(int i=0;i<32;i++){
        int x=(n>>i)&1;
    
        ans=(ans<<1)|x;
       } 
       return ans;
    }
}