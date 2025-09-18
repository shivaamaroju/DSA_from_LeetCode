class Solution {
    public int[] findOrder(int n, int[][] p) {
    int a[]=new int[n];
    HashMap<Integer,ArrayList<Integer>> mp=new HashMap<>();
    for(int i=0;i<n;i++){
        mp.put(i,new ArrayList<>());
    }
    for(var s: p){
    mp.get(s[1]).add(s[0]);
    a[s[0]]++;
    }
    Queue<Integer> q=new LinkedList<>();
    HashSet<Integer> st=new HashSet<>();
    for(int i=0;i<n;i++){
        if(a[i]==0){
            q.add(i);
            st.add(i);
        }
    }
int b[]=new int [n];
int i=0;
while(q.size()>0){
    int x=q.remove();
    b[i++]=x;
    for(var s:mp.get(x)){
        a[s]--;
        if(a[s]==0){
            q.add(s);
            st.add(s);
        }
    }
}
return i==n ?b :new int[0];





    }
}