class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sf[]=new int[26];
        int pf[]=new int [26];
        List<Integer> ll=new ArrayList<>();
        if (s.length() < p.length()) return ll;
        for(var ch:p.toCharArray())pf[ch-'a']++;
    int l=p.length();
    for(int i=0;i<l;i++){
        sf[s.charAt(i)-'a']++;
    }
    if(Arrays.equals(pf,sf))ll.add(0);
    for(int i=l;i<s.length();i++){
    char ch=s.charAt(i);
    char ch2=s.charAt(i-l);
    sf[ch-'a']++;
    sf[ch2-'a']--;
    if(Arrays.equals(sf,pf))ll.add(i-l+1);
    }
    return ll;
    }
}