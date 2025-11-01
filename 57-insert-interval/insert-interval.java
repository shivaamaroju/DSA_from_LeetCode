class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res=new ArrayList<>();
        int i=0;
        int n=intervals.length;
        while(i<n&&newInterval[0]>intervals[i][1]){
            res.add(intervals[i]);
           i= i+1;
        }
        while(i<n&&newInterval[1]>=intervals[i][0]){
           newInterval[0]=Math.min( newInterval[0],intervals[i][0]);
           newInterval[1]=Math.max( newInterval[1],intervals[i][1]);
           i=i+1;
        }
        res.add(newInterval);
  while(i<n){
            res.add(intervals[i]);
           i= i+1;
        }
        int a[][]=new int[res.size()][2];
        i=0;
        for(var s: res){
a[i][0]=s[0];
a[i][1]=s[1];
i=i+1;
        }
        return a;
    
    }
}