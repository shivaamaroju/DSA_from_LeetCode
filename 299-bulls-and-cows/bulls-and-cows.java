class Solution {
    public String getHint(String s, String g) {
       String a[]=s.split("");
       int c=0;
    HashMap<Integer,Integer> mp1=new HashMap<>();
    HashMap<Integer,Integer> mp2=new HashMap<>();
        for(int i=0;i<s.length();i++){
if(s.charAt(i)==g.charAt(i))c++;
else{
    int num1=(int)s.charAt(i)-'0';
    int num2=(int)g.charAt(i)-'0';
   mp1.put(num1,mp1.getOrDefault(num1,0)+1);
   mp2.put(num2,mp2.getOrDefault(num2,0)+1);
}
        }
        int sum=0;
        for(var ss:mp1.entrySet()){
if(mp2.containsKey(ss.getKey())){
    sum+=Math.min(mp2.get(ss.getKey()),ss.getValue());
}
        }

        return c+"A"+sum+"B";
    }
   
}