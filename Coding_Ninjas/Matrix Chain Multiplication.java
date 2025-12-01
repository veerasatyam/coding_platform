import java.util.*;

public class Solution 
{
    public static int minMultiplicationOperations(ArrayList<Integer> arr)
    {
        return find(arr, 1, arr.size() - 1);
    }
    private static int find(ArrayList<Integer> arr, int i, int j) {
        if (i == j) return 0;
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int steps = find(arr, i, k) + find(arr, k + 1, j) + arr.get(i - 1) * arr.get(k) * arr.get(j);
            min = Math.min(min, steps);
        }
        return min;
    }
}
