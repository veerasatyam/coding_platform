class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minR = m;
        int minC = n;
        for(int a[] : ops){
            minR = Math.min(a[0],minR);
            minC= Math.min(a[1],minC);
        }
        return minC*minR;
    }
}