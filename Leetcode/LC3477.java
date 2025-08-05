class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
       for(int i=0;i<fruits.length;i++){
        for(int j=0;j<baskets.length;j++){
            if(fruits[i]<=baskets[j]){
                fruits[i]=baskets[j]=-1;
                break;
            }
        }
       } 
       int remaining=0;
       for(int i=0;i<fruits.length;i++) if(fruits[i]!=-1) remaining++;
       return remaining;
    }
}