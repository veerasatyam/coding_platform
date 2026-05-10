class Solution {
    public int minFlips(String s) {
        int n = s.length();
        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
        }
        int zeros = n - ones;
        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, ones);
        ans = Math.min(ans, zeros);
        if (ones >= 1){
            ans = Math.min(ans, ones - 1);
        } else {
            ans = Math.min(ans, 1);
        }
        if (n >= 2) {
            int cost = 0;
            if (s.charAt(0) == '0') cost++;
            if (s.charAt(n - 1) == '0') cost++;
            for (int i = 1;i < n - 1;i++)if (s.charAt(i) == '1') cost++;
            ans = Math.min(ans, cost);
        }
        return ans;
    }
}