class Solution {
    public int[] findOrder(int n, int[][] p) {
        HashMap<Integer,List<Integer>> mp=new HashMap<>();
        int in[]=new int[n];
        for(int i=0;i<p.length;i++){
            mp.computeIfAbsent(p[i][1],k->new ArrayList<>()).add(p[i][0]);
            in[p[i][0]]++;
        }
        Queue<Integer> q=new LinkedList<>();
List<Integer> l=new ArrayList<>();
for(int i=0;i<n;i++){
if(in[i]==0)q.add(i);
}
while(q.size()>0){
    int x=q.remove();
    l.add(x);
    if(mp.containsKey(x)){
for(int s:mp.get(x)){
    in[s]--;
    if(in[s]==0)q.add(s);
}
    }
}
int a[]=new int[n];
if(l.size()!=n)return new int[]{};
for(int i=0;i<n;i++){
    a[i]=l.get(i);
}
return a;
    }
}