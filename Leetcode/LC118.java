import java.util.ArrayList;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        int[][] dp = new int[numRows][numRows];

        for(int i=0;i<numRows;i++){
            dp[i][0]=1;
            dp[i][i]=1;
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> curr = new ArrayList<>();
            for(int j=0;j<=i;j++){
                curr.add(dp[i][j]);
            }
            result.add(curr);
        }
        return result;
    }
}