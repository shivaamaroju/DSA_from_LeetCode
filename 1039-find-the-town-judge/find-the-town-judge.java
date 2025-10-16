class Solution {
    public int findJudge(int n, int[][] trust) {
        int in[]=new int[n+1];
        boolean f[]=new boolean [n+1];
        for(int i=0;i<trust.length;i++){
            in[trust[i][1]]++;
            f[trust[i][0]]=true;
        }
        for(int i=1;i<=n;i++)if(in[i]==n-1&&!f[i])return i;
        return -1;
    }
}