class Solution {
    public List<List<Integer>> combinationSum(int[] a, int t) {
     List<List<Integer>> l=new ArrayList<>();
     List<Integer> ll=new ArrayList<>();
     helper(a,t,l,ll,0);
return l;
    }
    public void helper(int a[],int t,     List<List<Integer>> l, List<Integer> ll,int idx){
        if(t<0)return;
        if(t==0){
l.add(new ArrayList<>(ll));
return;
        }
        for(int i=idx;i<a.length;i++){
ll.add(a[i]);
helper(a,t-a[i],l,ll,i);
ll.remove(ll.size()-1);
        }
    }
}