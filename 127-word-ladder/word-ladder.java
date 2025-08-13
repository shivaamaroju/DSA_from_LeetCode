class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs=new HashSet<>(wordList);
        Queue<String> q=new LinkedList<>();
        HashSet<String> vis=new HashSet<>();
        if(!hs.contains(endWord))return 0;
        q.add(beginWord);
        vis.add(beginWord);
        int c=1;
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                String st=q.remove();
                char ch[]=st.toCharArray();
                for(int j=0;j<ch.length;j++){
                    char or=ch[j];
                    for(char l='a';l<='z';l++){
                        if(or==l)continue;
                        ch[j]=l;
                        String ans=new String(ch);
                        if(ans.equals(endWord)) return c+1;
                        if(hs.contains(ans)&&!vis.contains(ans)){
                            q.add(ans);
                            vis.add(ans);
                        }
                    ch[j]=or;
                    }
                }
            }
                c++;
        }
        return 0;
    }
}