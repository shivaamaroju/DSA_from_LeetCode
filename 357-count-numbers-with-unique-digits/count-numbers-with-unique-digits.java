class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0)return 1;
int sum=10;
        for(int i=2;i<=n;i++){
int x=9;
int m=1;
int y=i;
boolean f=false;
while(y-->0){
m*=x;
if(!f)f=true;
else x--;
}
sum+=m;
        }
       
return sum;


    }
}