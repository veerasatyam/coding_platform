class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) buy = prices[i];
             else profit = Math.max(profit, prices[i] - buy);
        }
        
        return profit;
    }
}



class Solution {
    public int maxProfit(int[] a) {
        int min = a[0];
        int max = 0;
        for(int i=1;i<n;i++){
           int profit = a[i] - min;
           max = Math.max(profit,max);
           min = Math.min(a[i],min);
        }
        return max;
    }
}