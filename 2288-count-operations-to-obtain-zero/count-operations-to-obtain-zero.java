class Solution {
    int min=Integer.MAX_VALUE;
    public int countOperations(int num1, int num2) {
        helper(num1,num2,0);
        return min;
    }
    public void helper(int n,int m,int c){
        if(n==0||m==0){
            min=Math.min(min,c);
            return;
        }
        if(n<=m)helper(n,m-n,c+1);
        else helper(n-m,m,c+1);
    }
}