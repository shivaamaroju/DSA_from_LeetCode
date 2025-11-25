class Solution {
        int mod=(int)(1e9+7);
    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2;   
        long sum=1;
        long odd  = n / 2;  
        sum*=(power(5,even))%mod;
        sum=(sum)%mod;
        sum*=(power(4,odd))%mod;
        
        return (int)(sum%mod);
    }
    public long power(long x,long y){
        if(y<=0)return 1;
        long mid=power(x,y/2);
        if(y%2==1){
            return ((mid*mid)%mod*x)%mod;
        }
        return (mid*mid)%mod;
    }
}