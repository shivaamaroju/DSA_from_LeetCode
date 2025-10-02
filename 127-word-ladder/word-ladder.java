class Solution {
    public int ladderLength(String b, String e, List<String> l) {
        HashSet<String> hs=new HashSet<>(l);
        HashSet<String> vis=new HashSet<>();
        if(!hs.contains(e))return 0;
        Queue<String> q=new LinkedList<>();
        q.add(b);
        vis.add(b);
        int c=1;
        while(q.size()>0){
            int n=q.size();
            while(n-->0){
            String s=q.remove();
            char a[]=s.toCharArray();

            for(int i=0;i<a.length;i++){
                char or=a[i];
                for(char ch='a';ch<='z';ch++){
                    if(ch==or)continue;
                    a[i]=ch;
                    String t=new String(a);
                    if(t.equals(e))return c+1;
                    if(!vis.contains(t)&&hs.contains(t)){
                        vis.add(t);
                        q.add(t);

                    }
                    a[i]=or;
                }
            }}
            c++;
        }
        return 0;
    }
}