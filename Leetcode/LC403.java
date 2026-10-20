// pure recursive solution

class Solution {
    public boolean canCross(int[] stones) {
        return solve(stones, 0, 0);
    }

    private boolean solve(int[] stones, int index, int lastJump) {
        if (index == stones.length - 1) return true;
        for (int jump = lastJump - 1; jump <= lastJump + 1; jump++) {
            if (jump <= 0) {
                continue;
            }
            int nextPosition = stones[index] + jump;
            int nextIndex = index + 1;
            while (nextIndex < stones.length && stones[nextIndex] < nextPosition) {
                nextIndex++;
            }
            if (nextIndex < stones.length && stones[nextIndex] == nextPosition){
                if (solve(stones, nextIndex, jump)) {
                    return true;
                }
            }
        }
        return false;
    }
}

// recursion + memoization solution

import java.util.*;

class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) map.put(stones[i], i);
        Boolean[][] dp = new Boolean[stones.length][stones.length + 1];
        return solve(stones, 0, 0, dp, map);
    }
    private boolean solve(int[] stones, int index, int lastJump, Boolean[][] dp, Map<Integer, Integer> map) {
        if (index == stones.length - 1) {
            return true;
        }
        if (lastJump <= stones.length && dp[index][lastJump] != null) {
            return dp[index][lastJump];
        }
        for (int jump = lastJump - 1; jump <= lastJump + 1; jump++) {
            if (jump <= 0) {
                continue;
            }
            int nextPosition = stones[index] + jump;
            Integer nextIndex = map.get(nextPosition);
            if (nextIndex != null && solve(stones, nextIndex, jump, dp, map)) {
                if (lastJump <= stones.length) {
                    dp[index][lastJump] = true;
                }
                return true;
            }
        }
        if (lastJump <= stones.length) {
            dp[index][lastJump] = false;
        }
        return false;
    }
}