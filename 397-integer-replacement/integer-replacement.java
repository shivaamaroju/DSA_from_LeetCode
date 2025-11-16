class Solution {
    int min=Integer.MAX_VALUE;
    public int integerReplacement(int n) {
      return helper(n);  
    }
    public int helper(long n){
        if(n==1){
        return 0;
        }
      
        if(n%2==0)return 1+helper(n/2);
        else{
            return Math.min(1+helper(n+1),1+helper(n-1));
        }

       
    

    }

}