class Trie {
 Node root;
    public Trie() {
        root=new Node();
    }
    
    public void insert(String s) {
        Node temp=root;
for(int i=0;i<s.length();i++){
    int x=(int)s.charAt(i)-'a';
    if(temp.a[x]==null){
        temp.a[x]=new Node();
    }
    temp=temp.a[x];

}
temp.ew=true;
        
    }
    
    public boolean search(String s) {
           Node temp=root;
for(int i=0;i<s.length();i++){
    int x=(int)s.charAt(i)-'a';
    if(temp.a[x]==null){
       return false;
    }
    temp=temp.a[x];

}
return temp.ew;
    }
    
    public boolean startsWith(String s) {
      Node temp=root;
for(int i=0;i<s.length();i++){
    int x=(int)s.charAt(i)-'a';
    if(temp.a[x]==null){
       return false;
    }
    temp=temp.a[x];

}
return true;
    }
}



class Node{
    Node a[]=new Node[26];
    boolean ew =false;

}
