class Solution {
    public int maxValidSplits(int[] nums) {
        int n = nums.length;
        int maxScore = 0;
        for(int remIdx = -1; remIdx < n; remIdx++){
            int[] arr = new int[remIdx == -1 ? n : n - 1];
            int idx = 0;
            for(int i = 0; i < n; i++){
                if(i == remIdx) continue;
                arr[idx++] = nums[i];
            }
            int m = arr.length;
            if(m <= 1) continue;
            int[] prefGcd = new int[m];
            prefGcd[0] = arr[0];
            for(int i = 1; i < m; i++){
                prefGcd[i] = gcd(prefGcd[i - 1],arr[i]);
            }
            int[] suffGcd = new int[m];
            suffGcd[m - 1] = arr[m - 1];
            for (int i = m - 2; i >= 0; i--) {
                suffGcd[i] = gcd(suffGcd[i + 1], arr[i]);
            }
            int currentScore = 0;
            for(int i = 0; i < m - 1; i++){
                if(prefGcd[i] == suffGcd[i + 1]) currentScore++;
            }
            maxScore = Math.max(maxScore,currentScore);
        }
        return maxScore;
    }
    int gcd(int a,int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}