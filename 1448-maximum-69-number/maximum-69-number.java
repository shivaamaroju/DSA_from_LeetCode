class Solution {
    public int maximum69Number (int n) {
        int c=0;
        int k=n;
        int sum=0;
        while(n>0){
            c++;
            n/=10;
        }
        int a[]=new int[c];
        for(int i=c-1;i>=0;i--){
a[i]=k%10;
k=k/10;}
int m=0;
for(int i=0;i<c;i++){
    if(a[i]==6&m==0){
        sum=sum*10+9;
        m=1;

        }

    
    else if(a[i]==9||a[i]==6){
        sum=sum*10+a[i];
    }
}
return sum;
    }
}