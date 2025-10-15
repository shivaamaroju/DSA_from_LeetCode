class Solution {
    public int[] decode(int[] e, int f) {
        int a[]=new int[e.length+1];
        int j=0;
        a[j++]=f;
        for(var s:e){
            f=f^s;
            a[j++]=f;
        }
        return a;
    }
}