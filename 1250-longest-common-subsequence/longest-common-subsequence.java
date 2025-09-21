class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int a[][]=new int[text1.length()][text2.length()];
        for(int i=0;i<text1.length();i++){
           Arrays.fill(a[i],-1); 
        }
        return helper(text1,text2,0,0,0,a);
    }
    public int helper(String s,String t,int i,int j,int ans,int a[][]){
        if(i>=s.length()||j>=t.length())return 0;
        if(a[i][j]!=-1)return a[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return ans=1+helper(s,t,i+1,j+1,ans,a);
        }
        int op1=helper(s,t,i+1,j,ans,a);
        int op2=helper(s,t,i,j+1,ans,a);
        return a[i][j]=Math.max(op1,op2);

    }
}