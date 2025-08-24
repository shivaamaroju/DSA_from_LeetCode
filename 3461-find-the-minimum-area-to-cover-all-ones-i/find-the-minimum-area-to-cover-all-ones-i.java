class Solution {
    public int minimumArea(int[][] grid) {
        int sr=-1,er=-1,sc=90000,ec=-1;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    if(sr==-1)sr=i;
                  sc=Math.min(sc,j);
                    er=Math.max(er,i);
                    ec=Math.max(ec,j);
                }
            }
        }
        return ((er-sr)+1)*((ec-sc)+1);
    }
}