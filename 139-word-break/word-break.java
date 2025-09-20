class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie obj=new Trie();
        for(var ss:wordDict)obj.insert(ss);
        Boolean dp[]=new Boolean[s.length()];
        return obj.search(s,dp,0);
    }
}
class Node{
    Node a[]=new Node[26];
    boolean ew=false;
}
class Trie{
    Node root;
    Trie(){
        root=new Node();
    }
    public void insert(String s){
        Node temp=root;
        for(int i=0;i<s.length();i++){
            int ch=(int)s.charAt(i)-'a';
            if(temp.a[ch]==null){
                temp.a[ch]=new Node();
            }
            temp=temp.a[ch];
        }
        temp.ew=true;
    }
    public boolean search(String s,Boolean dp[],int idx){
        if(idx>=s.length())return true;
        if(dp[idx]!=null)return dp[idx];
        Node temp=root;
        for(int i=idx;i<s.length();i++){
            int ch=(int)s.charAt(i)-'a';
            if(temp.a[ch]==null){
               break;
            }
            temp=temp.a[ch];
            if(temp.ew&&search(s,dp,i+1)){
               return  dp[idx]=true;
            }
        }
        return dp[idx]=false;
    }
}