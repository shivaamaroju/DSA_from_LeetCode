class Solution {
    public int countPalindromicSubsequence(String s) {
        int c=0;
      int f[]=new int[26];
      int l[]=new int[26];
      Arrays.fill(f,-1);
      Arrays.fill(l,-1);
      int n=s.length();
      for(int i=0;i<n;i++){
int ch=s.charAt(i)-'a';
if(f[ch]==-1)f[ch]=i;
l[ch]=i;
      }
      for(int i=0;i<26;i++){
        if(f[i]!=-1&&l[i]-f[i]>=2){
        HashSet<Integer> hs=new HashSet<>();
        for(int j=f[i]+1;j<l[i];j++){
            hs.add((int)s.charAt(j));
        }
        c+=hs.size();
        }
      }
        return c;
        
    }
}