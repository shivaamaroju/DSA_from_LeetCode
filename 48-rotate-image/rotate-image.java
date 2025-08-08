class Solution {
    public void rotate(int[][] a) {
        int b[][]=new int[a.length][a.length];
        for(int i=0;i<a.length;i++){
            int k=0;
            for(int j=a.length-1;j>=0;j--){
                b[i][k++]=a[j][i];
            }
        }
        for(int i=0;i<a.length;i++){
        for(int j=0;j<a.length;j++){
a[i][j]=b[i][j];
        }}
      
       }
    }
