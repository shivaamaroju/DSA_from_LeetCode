class Solution {
    public int maxProfit(int[] prices) {
        int max=0,min=Integer.MAX_VALUE;
        for(var s: prices){
            if(s<min)min=s;
            else if(s-min>max)max=s-min;
        }
        return max;
    }
}