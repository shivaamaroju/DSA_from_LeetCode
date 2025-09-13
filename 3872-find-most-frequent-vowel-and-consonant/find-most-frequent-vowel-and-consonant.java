class Solution {
    public int maxFreqSum(String s) {
int a[]=new int[26];
        for(char ch:s.toCharArray()){
            a[(int)ch-'a']++;
        }
        int max1=0,max2=0;
        for(int i=0;i<26;i++){
            if(i==0||i==4||i==8||i==14||i==20){
                max1=Math.max(max1,a[i]);
            }
            else{
                max2=Math.max(max2,a[i]);
            }
        }
        
        // System.out.println(max1+" "+max2);
        return max1+max2;
    }
}