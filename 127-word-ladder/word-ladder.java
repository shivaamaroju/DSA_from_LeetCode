class Solution {
    public int ladderLength(String b, String e, List<String> w) {
        HashSet<String> hs=new HashSet<>(w);
        Queue<String> q=new LinkedList<>();
        HashSet<String> vis=new HashSet<>();
        if(!hs.contains(e))return 0;
        q.add(b);
        vis.add(b);
        int l=1;
        while(q.size()>0){
            int size=q.size();
            while(size-->0){
String s=q.remove();
char a[]=s.toCharArray();
for(int i=0;i<a.length;i++){
    char or=a[i];
    for(char ch='a';ch<='z';ch++){
        if(ch==or)continue;
        a[i]=ch;
        String ko=new String(a);
        if(ko.equals(e))return l+1;
        if(!vis.contains(ko)&&hs.contains(ko)){
            q.add(ko);
            vis.add(ko);
        }
        a[i]=or;
    } 
}

            }
l++;
        }

     return 0;   
    }
}