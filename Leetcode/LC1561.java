class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n=piles.length;
        int coins=0;
        for(int i=n-1;i>=n/3;i=i-2){
            coins = coins + piles[i-1];
        }
        return coins;
    }
}