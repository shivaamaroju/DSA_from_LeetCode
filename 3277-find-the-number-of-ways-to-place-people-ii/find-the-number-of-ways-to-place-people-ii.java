class Solution {
    public int numberOfPairs(int[][] p) {
        Arrays.sort(p,(x,y)->{
if(x[0]==y[0])return y[1]-x[1];
return x[0]-y[0];
        });
        int c=0;
        for(int i=0;i<p.length;i++){
            int x1=p[i][0];
            int y1=p[i][1];
            for(int j=i+1;j<p.length;j++){
                int x2=p[j][0];
                int y2=p[j][1];
                if(x1<=x2&&y1>=y2){
                    if(isvalid(i,j,p,x1,y1,x2,y2))c++;
                }

            }
        }
        return c;
    }
    public boolean isvalid(int i,int j,int a[][],int x1,int y1,int x2,int y2){
        for(int k=i+1;k<a.length;k++){
            if(k==j)continue;
int x3=a[k][0];
int y3=a[k][1];
if(x1<=x3&&x3<=x2&&y3>=y2&&y3<=y1)return false;
        }
    
    return true;}
}