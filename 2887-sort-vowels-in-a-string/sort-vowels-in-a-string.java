class Solution {
    public String sortVowels(String s) {
        PriorityQueue<Character> pq=new PriorityQueue<>((x,y)->x-y);
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(is(ch))pq.add(ch);
        }
        String t="";
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(is(ch))t+=pq.remove();
            else t+=ch;
        }
        return t;





            }
            public boolean is(char ch){
                String s=""+ch;
                s=s.toLowerCase();
                ch=s.charAt(0);
                return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
            }
}