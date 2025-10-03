// // recursion + hashMap
class Solution {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + num);
        }
        List<Integer> uniqueNums = new ArrayList<>(map.keySet());
        Collections.sort(uniqueNums);
        return helper(uniqueNums, map, 0);
    }

    private int helper(List<Integer> nums, HashMap<Integer, Integer> map, int index) {
        if (index >= nums.size()) return 0;
        int currentNum = nums.get(index);
        int pick = map.get(currentNum);
        int nextIndex = index + 1;
        if (nextIndex < nums.size() && nums.get(nextIndex) == currentNum + 1)  nextIndex++;
        pick += helper(nums, map, nextIndex);
        int skip = helper(nums, map, index + 1);
        return Math.max(pick, skip);
    }
}


// using house rober + frequency map 

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int a : nums) max = Math.max(a,max);
        int[] points = new int[max+1];
        for(int a : nums) points[a] += a;
        return rob(points);
    }

    public int rob(int[] nums) {
      int n = nums.length;
      if (n == 0) return 0;
      if (n == 1) return nums[0];
      int[] dp = new int[n];
      dp[0] = nums[0];
      dp[1] = Math.max(nums[0], nums[1]);
      for(int i = 2; i < n; i++) {
        dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
       }
        return dp[n - 1];
    }
}


//space optimisation 
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int a : nums) max = Math.max(a,max);
        int[] points = new int[max+1];
        for(int a : nums) points[a] += a;
        return rob(points);
    }

    public int rob(int[] nums) {
      int n = nums.length;
    if (n == 0) return 0;
    if (n == 1) return nums[0];
    int prev2 = nums[0];           
    int prev1 = Math.max(nums[0], nums[1]);
    for (int i = 2; i < n; i++) {
        int curr = Math.max(prev1, nums[i] + prev2);
        prev2 = prev1;
        prev1 = curr;
    }
    return prev1;
    }
}

