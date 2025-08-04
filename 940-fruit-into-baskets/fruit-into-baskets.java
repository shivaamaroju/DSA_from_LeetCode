class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        int st=0;
        int max=0;
        for(int i=0;i<fruits.length;i++){
            mp.put(fruits[i],mp.getOrDefault(fruits[i],0)+1);
            if(mp.size()>2){
            int x=mp.get(fruits[st]);
            if(x==1)mp.remove(fruits[st]);
            else mp.put(fruits[st],x-1);
            st++;
            }
            int sum=0;
            for(var s:mp.entrySet()){
                sum+=s.getValue();
            }
            max=Math.max(sum,max);

        }
return max;
    }
}