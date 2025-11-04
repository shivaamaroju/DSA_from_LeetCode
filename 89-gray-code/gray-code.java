class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> l=new ArrayList<>();
        l.add(0);
        l.add(1);
        for(int i=2;i<=n;i++){
           List<Integer> x= dosome(l,i);
           l=new ArrayList<>(x);
        }
        return l;

    }
    public List<Integer> dosome(List<Integer> l,int i){
        ArrayList<Integer> x=new ArrayList<>(l);
        Collections.reverse(x);
        ArrayList<Integer> ans=new ArrayList<>(l);
        for(int s:x){
            ans.add((1<<(i-1))|s);
        }
     
        return ans;
    }
}