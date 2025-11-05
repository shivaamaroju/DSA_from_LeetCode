class Solution {
    public int maxProfit(int[] p) {
        int n=p.length;
        int dp[][]=new int[n+1][2];
        for(int idx=n-1;idx>=0;idx--){
            for(int buy=0;buy<=1;buy++){
       int pf=0;
        if(buy==1){
pf=Math.max(-p[idx]+dp[idx+1][0],dp[idx+1][1]);
        }
        else{
pf=Math.max(p[idx]+dp[idx+1][1],dp[idx+1][0]);

        }
            dp[idx][buy]=pf;
            }
        }
       return dp[0][1]; 
    }
   
    
}