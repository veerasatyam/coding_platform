//pure recursion 
class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int p : power)
            freq.put(p, freq.getOrDefault(p, 0) + 1);

        List<Integer> list = new ArrayList<>(freq.keySet());
        Collections.sort(list);

        return helper(list, freq, 0);
    }

    private long helper(List<Integer> list, Map<Integer, Integer> freq, int index) {
        if (index >= list.size()) return 0;
        long skip = helper(list, freq, index + 1);

        long take = (long) list.get(index) * freq.get(list.get(index));
        int next = index + 1;
        while (next < list.size() && list.get(next) - list.get(index) <= 2) next++;
        take += helper(list, freq, next);
        return Math.max(take, skip);
    }
}
//recusion + memorization 
class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int p : power)
            freq.put(p, freq.getOrDefault(p, 0) + 1);
        List<Integer> list = new ArrayList<>(freq.keySet());
        Collections.sort(list);
        long[] dp = new long[list.size()];
        Arrays.fill(dp, -1L);
        return helper(list, freq, 0, dp);
    }

    private long helper(List<Integer> list, Map<Integer, Integer> freq, int index, long[] dp) {
        if (index >= list.size()) return 0;
        if (dp[index] != -1) return dp[index];
        long skip = helper(list, freq, index + 1, dp);
        long take = (long) list.get(index) * freq.get(list.get(index));
        int next = index + 1;
        while (next < list.size() && list.get(next) - list.get(index) <= 2) next++;
        take += helper(list, freq, next, dp);
        dp[index] = Math.max(take, skip);
        return dp[index];
    }
}


//dp + two pointers

class Solution {
    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);
        long[] dp = new long[power.length];
        long md = 0;
        dp[0] = power[0];
        for (int i = 1, j = 0; i < power.length; i++) {
            if (power[i] == power[i-1]) {
                dp[i] = dp[i-1]+power[i];
            } else {
                while (power[j]+2 < power[i]) {
                    md = Math.max(md, dp[j]);
                    j++;
                }
                dp[i] = md + power[i];
            }
        }
        
        long max = 0;
        for (long n : dp) max = Math.max(max, n);
        return max;
    }
}