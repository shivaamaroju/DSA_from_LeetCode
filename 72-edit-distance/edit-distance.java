class Solution {
    public int minDistance(String s, String t) {
        int dp[][]=new int [s.length()][t.length()];
        for(int i=0;i<s.length();i++)Arrays.fill(dp[i],-1);
        return helper(s,t,s.length()-1,t.length()-1,dp)+1;
    }
    public int helper(String s,String t,int i,int j,int dp[][]){
        if(i<0)return j;
        if(j<0)return i;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s.charAt(i)==t.charAt(j))return helper(s,t,i-1,j-1,dp);
        int in=1+helper(s,t,i-1,j,dp);
        int d=1+helper(s,t,i,j-1,dp);
        int r=1+helper(s,t,i-1,j-1,dp);
        return dp[i][j]= Math.min(in,Math.min(d,r));
    }
}