class Solution {
    public int[] findDiagonalOrder(int[][] a) {
         List<Integer> l=new ArrayList<>();
    int r=a.length;
    int c=a[0].length;
    int i=0,j=0,k=0;
        List<Integer> temp=new ArrayList<>();
        for(int y=0;y<r;y++){
         i=y;j=0;
        while(i>=0 && j>=0 && i<r && j<c){
             temp.add(a[i--][j++]);
        }
           if(k%2==1)Collections.reverse(temp);
            l.addAll(temp);
            temp=new ArrayList<>();
            k++;
       }
        k=0;
        for(int x=1;x<c;x++){
        i=r-1;j=x;
        while(i>=0 && j>=0 && i<r && j<c){
             temp.add(a[i--][j++]);
        }
           if((k%2==0 && r%2==1) ||(k%2==1 && r%2==0 ))Collections.reverse(temp);
            l.addAll(temp);
            temp=new ArrayList<>();
            k++;
       }

    int a1[]=new int[l.size()];
    for(var i2=0;i2<l.size();i2++)a1[i2]=l.get(i2);
    return a1;
}

}