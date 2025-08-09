class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0)return false;
        int c=0;
        while(n>0){
            int x=n&1;
            if(x==1)c++;
            if(c>=2)return false;
            n=n>>1;
        }
        return true;
    }
}