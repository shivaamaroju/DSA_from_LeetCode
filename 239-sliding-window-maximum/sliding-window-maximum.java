class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int a[]=new int[nums.length-k+1];
        int st=0;
        Deque<Integer> q=new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            while(!q.isEmpty()&&(i-q.peekFirst())>=k)q.removeFirst();
            while(!q.isEmpty()&&nums[i]>nums[q.peekLast()])q.removeLast();
            q.addLast(i);
            if(i>=k-1&&!q.isEmpty())a[st++]=nums[q.peekFirst()];
        }
        return a;
    }
}