class Solution {
    public int smallestNumber(int n) {
        int c=0;
        while(n>0){
            n=n>>1;
            c++;
        }
        return (int)Math.pow(2,c)-1;
    }
}