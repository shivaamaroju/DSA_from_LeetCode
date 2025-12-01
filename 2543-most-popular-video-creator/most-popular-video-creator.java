class Solution {
    public List<List<String>> mostPopularCreator(String[] c, String[] ids, int[] views) {
HashMap<String,Pair>mp=new HashMap<>();
int n=ids.length;
long maxsum=0;
for(int i=0;i<n;i++){
if(mp.containsKey(c[i])){
    Pair p=mp.get(c[i]);
    p.sum+=views[i];
    if(p.max<views[i]){
        p.max=views[i];
        p.id=ids[i];
    }
   else if(p.max==views[i]){
        p.max=views[i];
        p.id=compare(p.id,ids[i]);
    }
    maxsum=Math.max(maxsum,p.sum);
}
else{
    mp.put(c[i],new Pair(views[i],ids[i],views[i]));
     maxsum=Math.max(maxsum,views[i]);
}
       }
       List<List<String>> ans=new ArrayList<>();
       for(var s:mp.entrySet()){
Pair p=s.getValue();
if(p.sum==maxsum){
    List<String> l=new ArrayList<>();
    l.add(s.getKey());
    l.add(p.id);
    ans.add(l);
}
       }
return ans;
    }
    public String compare(String s,String t){
        return s.compareTo(t)<0?s:t;
    }
}
class Pair{
    int max;
    String id;
    long sum;
    Pair(int max,String id,long sum){
        this.max=max;
        this.id=id;
        this.sum=sum;
    }
}