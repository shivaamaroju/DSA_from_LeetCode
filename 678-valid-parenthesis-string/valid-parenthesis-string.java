class Solution {
    public boolean checkValidString(String s) {
        int c=s.length();
        Boolean dp[][]=new Boolean[c][c];
        return helper(s,0,0,dp);
    }
    public boolean helper(String s,int idx,int c,Boolean dp[][]){
        if(c<0)return false;
        if(idx==s.length())return c==0;
        if(dp[idx][c]!=null)return dp[idx][c];
        if(s.charAt(idx)=='(')return dp[idx][c]=helper(s,idx+1,c+1,dp);
    else if(s.charAt(idx)==')')return dp[idx][c]=helper(s,idx+1,c-1,dp);
    return dp[idx][c]= helper(s,idx+1,c+1,dp) || helper(s,idx+1,c-1,dp)||helper(s,idx+1,c,dp);
    }
}