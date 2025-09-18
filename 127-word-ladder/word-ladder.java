class Solution {
    public int ladderLength(String b, String e, List<String> wordList) {
        HashSet<String> hs=new HashSet<>(wordList);
        if(!hs.contains(e))return 0;
        Queue<String> q=new LinkedList<>();
        HashSet<String> vis=new HashSet<>();
        vis.add(b);
        q.add(b);
        int c=1;
        while(q.size()>0){
int n=q.size();
while(n-->0){
    String s=q.remove();
    char ch[]=s.toCharArray();
    for(int i=0;i<ch.length;i++){
        char or=ch[i];
        for(char j='a';j<='z';j++){
if(j==or)continue;
ch[i]=j;
String ss=new String(ch);
if(ss.equals(e))return c+1;
if(hs.contains(ss)&&!vis.contains(ss)){
    q.add(ss);
    vis.add(ss);
}
ch[i]=or;
        }
    }

}
c++;
        }
        return 0;
    }
}