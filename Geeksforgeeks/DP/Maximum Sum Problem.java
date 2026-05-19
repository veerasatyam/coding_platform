// recursion

class Solution {
    public int maxSum(int n) {
        return helper(n);
    }
    private int helper(int n) {
        if (n == 0) return 0;
        int exchange = helper(n / 2) + helper(n / 3) + helper(n / 4);
        return Math.max(n, exchange);
    }
}

// recursion + memoization

class Solution {
    Map<Integer,Integer> map;
    public int maxSum(int n) {
        map = new HashMap<>();
        return helper(n);
    }
    private int helper(int n) {
        if (n == 0) return 0;
        if(map.containsKey(n)) return map.get(n);
        int exchange = helper(n / 2) + helper(n / 3) + helper(n / 4);
        map.put(n,Math.max(n, exchange));
        return map.get(n);
    }
}