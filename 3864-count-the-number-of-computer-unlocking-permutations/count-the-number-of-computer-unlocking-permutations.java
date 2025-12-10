class Solution {
    public int countPermutations(int[] c) {
       int f=c[0];
       for(int i=1;i<c.length;i++)if(f>=c[i])return 0;
       int mod=(int)(1e9+7);
       long fact=1;
       for(int i=2;i<c.length;i++)fact=(((fact)%mod)*i)%mod;
       return (int)fact%mod;
    }
}