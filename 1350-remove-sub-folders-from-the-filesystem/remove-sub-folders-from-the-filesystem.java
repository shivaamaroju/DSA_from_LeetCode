class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Trie obj=new Trie();
        Arrays.sort(folder);
        List<String> l=new ArrayList<>();
        for(var s: folder){
            if(obj.insert(s))l.add(s);
        }
        return l;

    }
}
class Node{
    HashMap<String,Node> mp=new HashMap<>();
    boolean ew=false;
}
class Trie{
    Node  root=new Node();
    public boolean insert(String s){
Node temp=root;
String a[]=s.split("/");
for(int i=0;i<a.length;i++){
    if(temp.ew)return false;
   if(!temp.mp.containsKey(a[i])){
    temp.mp.put(a[i],new Node());
   } 
   temp=temp.mp.get(a[i]);
}
temp.ew=true;
return true;
    }

}