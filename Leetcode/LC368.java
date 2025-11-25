class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        int max = 1;
        int lastIndex = 0;
        for(int i=0;i<n;i++){
            dp[i] = 1;
            hash[i] = i;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[j]+1>dp[i]){
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }
            if(dp[i]>max){
                max = dp[i];
                lastIndex = i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        int curr = lastIndex;
        while(hash[curr] != curr){
            ans.add(nums[curr]);
            curr = hash[curr];
        }
        ans.add(nums[curr]);
        Collections.reverse(ans);
        return ans;
    }
}