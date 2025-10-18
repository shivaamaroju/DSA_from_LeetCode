class DSU{
    int p[],s[];
    public DSU(int n){
        p=new int[n];
        s=new int[n];
        for(int i=0;i<n;i++){
            p[i]=i;
            s[i]=1;
        }
    }
    int find(int x){
 if (p[x] != x) {
            p[x] = find(p[x]); 
        }
        return p[x];
    }
    void merge(int x,int y){
        int px=find(x);
        int py=find(y);
        if(px!=py){
            if(s[px]<s[py]){
                p[px]=y;
                s[py]+=s[px];
            }
            else{
                p[py]=px;
                s[px]+=s[py];
            }
        }
    }
}
class Solution {
    public boolean validPath(int n, int[][] edges, int s, int d) {
        DSU k=new DSU(n);
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0],v=edges[i][1];
            k.merge(u,v);
        }
        // // for(var s:k.p){
        // //     System.out.print(s+" ");
        // // }
        // int des=k.p[d];
        // while(k.p[des]!=des){
        //     des=k.p[des];
        // }
        return k.find(s) == k.find(d);
    }
}