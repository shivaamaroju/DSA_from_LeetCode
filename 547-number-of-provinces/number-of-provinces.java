class Solution {
    public int findCircleNum(int[][] a) {
        int n=a.length;
        DSU obj=new DSU(n);
        int x=n;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
if(a[i][j]==1)obj.merge(i+1,j+1);
            }
        }
        HashSet<Integer> hs=new HashSet();
        // HashSet<Integer> hs = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            hs.add(obj.find(i));   
        }
        return hs.size();
    }
}
class DSU{
    int p[],s[];
    DSU(int n){
        p=new int[n+1];
        s=new int[n+1];
        for(int i=1;i<=n;i++){
p[i]=i;
s[i]=1;
        }
    }
    public int find(int x){
        if(p[x]!=x){
            p[x]=find(p[x]);
        }
        return p[x];
    }
    public boolean merge(int x,int y){
        int px=find(x);
        int py=find(y);
        if(px!=py){
            if(s[px]<s[py]){
                s[py]+=s[px];
                p[px]=p[py];
            }
            else{
                 s[px]+=s[py];
                p[py]=p[px];
            }
            return true;
        }
        return false;
    }
}