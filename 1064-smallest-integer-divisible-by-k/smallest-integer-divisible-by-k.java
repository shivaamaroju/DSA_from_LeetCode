class Solution {
    public int smallestRepunitDivByK(int k) {
        List<Integer> ans=new ArrayList<>();
        Integer n=1;
        for(int i=1;i<=k&&k>=Math.log10(n);i++){
            ans.add((n%k));
            n=(((n%k)*10%k)+1)%k;
        }
        for(int i=0;i<ans.size();i++){
            if(ans.get(i)%k==0)return i+1;
        }
        return -1;
    }
}