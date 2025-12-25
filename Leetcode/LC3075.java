class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int count = 0;
        long sum = 0;
        int n = happiness.length;
        for(int i=n-1;i>=n-k;i--) {
            int x = happiness[i] - count;
            if(x >= 0){
                sum += x;
            }
            count++;
        }
        return sum;
    }
}