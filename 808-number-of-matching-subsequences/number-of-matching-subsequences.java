class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Trie obj=new Trie();
        obj.insert(s);
        int c=0;
         HashSet<String> find=new HashSet<>();
         HashSet<String> notfind=new HashSet<>();
        for(var ss:words){
            if(ss.length()<=s.length()){
          if(notfind.contains(ss))continue;
                if(find.contains(ss)||obj.search(ss)){
find.add(ss);
c++;
                }
                else notfind.add(ss);
            }
        }
        return c;
    }
}
class Node {
    Node a[]=new Node[26];
    boolean ew=false;
}
class Trie{
    Node root= new Node();
    public void insert(String s){
        Node temp=root;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(temp.a[ch-'a']==null){
                temp.a[ch-'a']=new Node();
            }
            temp=temp.a[ch-'a'];
        }
        temp.ew=true;
    }
    public boolean search(String s){
        Node temp=root;
        int j=0;
        int c=0;
       
       while(temp!=null&&j<s.length()){
        char ch=s.charAt(j);
        if(temp.a[ch-'a']==null){
            boolean f=false;
            for(int i=0;i<26;i++){
                if(temp.a[i]!=null){
                    temp=temp.a[i];
                    f=true;
                    break;}

            }
            if(!f)break;
        }
        else{
            temp=temp.a[ch-'a'];
            c++;
            j++;
        }

       }
       return c==s.length();
    }
}