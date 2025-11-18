class Solution {
    public List<String> removeSubfolders(String[] folder) {
       Arrays.sort(folder); 
       Trie obj=new Trie();
       List<String> ans=new ArrayList<>();
      for(var s:folder){
        if(obj.build(s))ans.add(s);
      } 
      return ans;
    }
}
class Node{
HashMap<String,Node> mp=new HashMap<>();
boolean ew=false;
}
class Trie{
    Node root=new Node();
public boolean build(String s){
        Node temp=root;
        String ss[]=s.split("/");
for(int i=0;i<ss.length;i++){
if(temp.ew)return false;
String ch=ss[i];
if(!temp.mp.containsKey(ch)){
temp.mp.put(ch,new Node());
}
temp=temp.mp.get(ch);
        }
        temp.ew=true;
        return true;
    }
}