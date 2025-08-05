class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] basket) {
        int c=fruits.length;
        for(int i=0;i<fruits.length;i++){
            for(int j=0;j<basket.length;j++){
                if(fruits[i]<=basket[j]&&basket[j]!=-1){
                    c--;
                    basket[j]=-1;
                    break;
                }
            }
        }
        return c;
    }
}