class Solution {
    public int numSquares(int n) {
       if(issq(n))return 1;
       for(int i=1;i<=Math.sqrt(n);i++){
        int x=n-(i*i);
        if(issq(x))return 2;
       }
       for(int i=1;i<=Math.sqrt(n);i++){
        for(int j=1;j<=Math.sqrt(n);j++){
         int    x=n-i*i-j*j;
         if(issq(x))return 3;
        }
       }
return 4;



    }
    public boolean issq(int n){
        int x=(int)Math.sqrt(n);

        return x*x==n;
    }
}