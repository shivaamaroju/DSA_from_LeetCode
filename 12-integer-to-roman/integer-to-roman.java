class Solution {
    public String intToRoman(int num) {
        String s="";
        while(num>0){
            int r=remainder(num);
            String s2=alpha(r);
            s+=s2;
            num-=r;
        }
        return s;
    }
    public static int remainder(int num){
        int num2=num;
         int c=0;
        while(num>0){
            c=c+1;
            num=num/10;
        }
        int k=(int)Math.pow(10, c-1);
       int just= num2/k;
        return just*k;
    }
    public static String alpha(int r){
        if(r==3000) return "MMM";
    if(r==2000) return "MM";
    if(r==1000) return "M";
    if(r==900) return "CM";
    if(r==800) return "DCCC";
    if(r==700) return "DCC";
    if(r==600) return "DC";
    if(r==500) return "D";
    if(r==400) return "CD";
    if(r==300) return "CCC";
    if(r==200) return "CC";
    if(r==100) return "C";
    if(r==90) return "XC";
    if(r==80) return "LXXX";
    if(r==70) return "LXX";
    if(r==60) return "LX";
    if(r==50)return "L";
    if(r==40)return "XL";
    if(r==30)return"XXX";
    if(r==20)return"XX";
    if(r==10)return"X";
    if(r==9)return "IX";
    if(r==8)return "VIII";
    if(r==7)return "VII";
    if(r==6)return"VI";
    if(r==5)return "V";
    if(r==3)return "III";
    if(r==2)return "II";
    if(r==1)return "I";
    if(r==4)return"IV";

    return " ";
    
    
    
    
    
    
        
        }

        
}