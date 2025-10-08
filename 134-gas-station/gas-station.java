class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length==1&&gas[0]>=cost[0])return 0;
        if(gas.length==1&&gas[0]<cost[0])return -1;
        for(int i=0;i<gas.length;i++){
            int cal=gas[i]-cost[i];
            if(cal>0){
            boolean idx=helper(gas,cost,cal,(i+1)%gas.length,i);
            if(idx)return i;}

        }
        return -1;
    }
    public boolean helper(int gas[],int cost[],int cal,int idx,int t){
        if(idx==t)return true;
        if(cal<=0)return false;
        cal+=gas[idx]-cost[idx];
        if(cal<0)return false;
        return helper(gas,cost,cal,(idx+1)%gas.length,t);
    }
}