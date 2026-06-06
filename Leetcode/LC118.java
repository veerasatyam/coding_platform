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


// different type of questions which might ask 
// 1. print the nth row of the pascal triangle
// 2. give n amd m print the mth element of nth row of the pascal triangle
// for 2 question we can use the formula nCr = n! / (r! * (n - r)!) and we can calculate the factorial using the loop or we can use the recursive approach but it will give TLE for large values of n and r so we can use the dynamic programming approach to calculate the factorial and store it in an array and then use it to calculate the nCr value in O(1) time complexity after O(n) time complexity for precomputation of factorial values.
// code for 2nd question to calculate the mth element of nth row of the pascal triangle using the formula nCr = n! / (r! * (n - r)!)
// class Solution {
// public int findNCr(int n, int r) {
//    int result = 1;
//   for (int i = 0; i <= r; i++) {
//     result = result * (n - i);
        // result = result / i + 1;
//   }
//   return result;



// 1. print the nth row of the pascal triangle from the fromula nCr = n! / (r! * (n - r)!) we can calculate the nth row of the pascal triangle in O(n) time complexity and O(1) space complexity
// class Solution {
//     public List<Integer> getRow(int rowIndex) {
//         List<Integer> result = new ArrayList<>();
//         int result = 1;
//         for (int i = 0; i <= rowIndex; i++) {
//             result = result * (rowIndex - i);
//             result = result / i + 1;
//             result.add(result);
//         }
//         return result;
//     }
// }
//     