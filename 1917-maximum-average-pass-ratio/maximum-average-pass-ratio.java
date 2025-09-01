class Solution {
    public double maxAverageRatio(int[][] c, int e) {
        
        PriorityQueue<int []> pq=new PriorityQueue<>((x,y)->{
 double gain1 = ((double)(x[0] + 1) / (x[1] + 1)) - ((double)x[0] / x[1]);
            double gain2 = ((double)(y[0] + 1) / (y[1] + 1)) - ((double)y[0] / y[1]);
            return Double.compare(gain2, gain1);
        });
        for(var s:c)pq.add(s);
        while(e-->0){
        int a[]=pq.remove();
        a[0]=a[0]+1;
        a[1]=a[1]+1;
        pq.add(a);
        }
        double sum=0.0;
        while(pq.size()>0){
            int a[]=pq.remove();
            sum=sum+(double)a[0]/a[1];
        }
        return sum/c.length;



    }
}