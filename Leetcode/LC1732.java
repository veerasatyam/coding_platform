class Solution {
    public int largestAltitude(int[] gain) {
        int maxl = 0;
        int sum = 0;
        for(int a: gain){
          sum += a;
          maxl = Math.max(sum,maxl);   
        }
        return maxl;
    }
}