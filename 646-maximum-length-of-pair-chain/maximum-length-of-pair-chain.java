class Solution {
    public int findLongestChain(int[][] a) {
        int c=0;
        Arrays.sort(a,(x,y)->{
            return x[1]-y[1];
        });
        int end=a[0][1];
        int max=1;
        for(int i=1;i<a.length;i++){
            if(a[i][0]>end){
                max++;
                end=a[i][1];
            }
        }
return max;
    }
}