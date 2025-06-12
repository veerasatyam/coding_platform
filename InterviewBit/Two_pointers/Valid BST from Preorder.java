import java.util.*;

public class Solution {
    public int solve(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int lowerBound = Integer.MIN_VALUE;
        Set<Integer> seen = new HashSet<>();

        for (int value : A) {
            if (value < lowerBound) return 0;
            if (seen.contains(value)) return 0;

            while (!stack.isEmpty() && value > stack.peek()) {
                lowerBound = stack.pop();
            }
            stack.push(value);
            seen.add(value);
        }
        return 1;
    }
}
