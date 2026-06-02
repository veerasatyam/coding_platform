class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int total = 0;
        int n = cost.length;
        int skip = 0;
        for(int i = n-1; i>=0; i--){
            if(skip == 2){
                skip = 0;
                continue;
            }
            total += cost[i];
            skip++;
        }
        return total;
    }
}