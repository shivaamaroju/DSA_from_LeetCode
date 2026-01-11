class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        int dp[][]=new int[t.size()][t.size()];
        dp[0][0]=t.get(0).get(0);
        for(int i=1;i<t.size();i++){
            for(int j=0;j<t.get(i).size();j++){
int d=0,dg=0;
if(j<t.get(i-1).size())d=t.get(i).get(j)+dp[i-1][j];
else d+=(int)1e9;
if(j-1>=0)dg+=t.get(i).get(j)+dp[i-1][j-1];
else dg+=(int)1e9;
dp[i][j]=Math.min(d,dg);
            }
        }
        int ans=(int)(1e9);
for(int i=0;i<t.get(t.size()-1).size();i++){
    ans=Math.min(ans,dp[t.size()-1][i]);
}
return ans;

    }
    
    

    
}