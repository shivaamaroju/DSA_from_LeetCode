class Solution {
    public int[] twoSum(int[] a, int t) {
        int b[]=new int[2];
        //int d[]=a;
for(int i=0;i<a.length;i++){
    int c=t-a[i];
    int k=com(c,a,i);
    if(k!=-1){
        b[0]=i;
        b[1]=k;
return b;

    }
}
return b;

        
    }
    public int com(int t,int a[],int j){
    
    for(int i=j+1;i<a.length;i++){
        if(a[i]==t)return i;
    }
    return -1;
    }
}