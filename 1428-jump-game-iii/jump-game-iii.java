class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean vis[]=new boolean[arr.length];
        return helper(arr,vis,start);
    }
    public boolean helper(int a[],boolean vis[],int start){
    if(start>=a.length||start<0||vis[start])return false;
    if(a[start]==0)return true;
    vis[start]=true;
    boolean left=helper(a,vis,start+a[start]);
    boolean right=helper(a,vis,start-a[start]);
    return left||right;
}}