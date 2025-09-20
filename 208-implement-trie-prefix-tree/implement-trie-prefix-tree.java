class Trie {
Node root;
    public Trie() {
     root=new Node();   
    }
    
    public void insert(String word) {
        Node temp=root;
        for(int i=0;i<word.length();i++){
            int ch=(int)word.charAt(i)-'a';
            if(temp.a[ch]==null){
                temp.a[ch]=new Node();
            }
            temp=temp.a[ch];






            }
            temp.ew=true;
    }
    
    public boolean search(String word) {
       Node temp=root;
        for(int i=0;i<word.length();i++){
            int ch=(int)word.charAt(i)-'a';
            if(temp.a[ch]==null)return false;
            temp=temp.a[ch];
        }
        return temp.ew;
    }
    
    public boolean startsWith(String prefix) {
       Node temp=root;
       for(int i=0;i<prefix.length();i++){
        int ch=(int)prefix.charAt(i)-'a';
        if(temp.a[ch]==null)return false;
        temp=temp.a[ch];
       } 
       return true;
    }
}
class Node{
    Node a[]=new Node[26];
    boolean ew=false;
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */