class Solution {
    public boolean completePrime(int num) {
 
    
    StringBuffer sb=new StringBuffer(""+num);
    for(int i=0;i<sb.length();i++){
        int x=Integer.parseInt(sb.substring(0,i+1));
        int y=Integer.parseInt(sb.substring(sb.length()-i-1));
        if(!prime(x)||!prime(y))return false;

    }
    return true;

    }
    public boolean prime(int x){
        if(x<2)return false;
        for(int i=2;i<=Math.sqrt(x);i++){
            if(x%i==0)return false;
        }
        return true;
    }
}