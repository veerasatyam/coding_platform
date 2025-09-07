class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        if(m*k > bloomDay.length) return -1;
        for(int a : bloomDay){
            min = Math.min(min,a);
            max = Math.max(max,a);
        }
        int ans = max;
        int low = min,high=max;
        while(low<=high){
            int mid = (low+high)/2;
            if(canMake(bloomDay,mid,m,k)){
                ans = mid;
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    private boolean canMake(int[] bloomDay, int days, int m, int k) {
    int count = 0;
    int bouquets = 0;
    for (int day : bloomDay) {
        if (day <= days) {
            count++;
            if (count == k) {
                bouquets++;
                count = 0;
            }
        } else {
            count = 0;
        }
    }

    return bouquets >= m;
}

}