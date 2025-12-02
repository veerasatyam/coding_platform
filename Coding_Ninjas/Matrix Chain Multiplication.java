// Pure recursion
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
            int steps = find(arr, i, k) +  find(arr, k + 1, j) + arr.get(i - 1) * arr.get(k) * arr.get(j);
            min = Math.min(min, steps);
        }
        return min;
    }
}



// Tabulation 

import java.util.* ;
import java.io.*; 

import java.util.ArrayList;

public class Solution 
{
    public static int minMultiplicationOperations(ArrayList<Integer> arr){
    int N = arr.size();
    int[][] dp = new int[N][N];

    for(int len = 2; len < N; len++){
        for(int i = 1; i + len - 1 < N; i++){
            int j = i + len - 1;
            dp[i][j] = Integer.MAX_VALUE;

            for(int k = i; k < j; k++){
                int cost = dp[i][k] + dp[k+1][j] + arr.get(i-1) * arr.get(k) * arr.get(j);
                dp[i][j] = Math.min(dp[i][j], cost);
            }
        }
    }
    return dp[1][N-1];
}

}