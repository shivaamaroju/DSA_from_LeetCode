class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.sum-y.sum);
for(int i=0;i<Math.min(nums1.length,k);i++)pq.add(new Pair(nums1[i]+nums2[0],i,0));
List<List<Integer>> ans=new ArrayList<>();

while(k>0&&pq.size()>0){
  Pair p=pq.remove();
  List<Integer> l=new ArrayList<>();
  l.add(nums1[p.i]);
  l.add(nums2[p.j]);
  ans.add(l);
  if(p.j+1<nums2.length)pq.add(new Pair(nums1[p.i]+nums2[p.j+1],p.i,p.j+1));
k--;
}
return ans;





    }
}
class Pair{
    int sum,i,j;
    Pair(int sum,int i,int j){
        this.sum=sum;
        this.i=i;
        this.j=j;
    }
}