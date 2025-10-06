class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
     Deque<Integer> dq=new LinkedList<>();
     int st=0;
     List<Integer> l=new ArrayList<>();
     for(int i=0;i<nums.length;i++){
        while(dq.size()>0&&(i-dq.peekFirst())>=k){
            dq.removeFirst();}
        while(dq.size()>0&&nums[dq.peekLast()]<=nums[i])dq.removeLast();
        dq.add(i);
        if(i>=k-1&&dq.size()>0)l.add(nums[dq.peekFirst()]);
     }
     int a[]=new int[l.size()];
int i=0;
for(var s:l)a[i++]=s;
return a;
    }
}