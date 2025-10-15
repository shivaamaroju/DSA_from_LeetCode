class Solution {
    public List<String> printVertically(String s) {
    int k=0;
String a[]=s.split(" ");

int max=0;
List<String> l=new ArrayList<>();
for(int i=0;i<a.length;i++){
max=Math.max(max,a[i].length());
}

int j=0;
while(j<max){
    String ans="";
    for(int i=0;i<a.length;i++){
String  d=a[i];
if(d.length()>j){
ans+=a[i].charAt(j);
}
else {
ans+=" ";
}

    }
    l.add(ans.stripTrailing());
    j++;
}
return l;
    }
}