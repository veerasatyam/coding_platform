class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum < 1 || sum > 9 * num) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int remainingSum = sum;
        for (int i = 0; i < num; i++) {
            for (int d = 9; d >= 0; d--) {
                int remainingPositions = num - 1 - i;
                if (remainingSum - d <= 9 * remainingPositions && remainingSum - d >= 0) {
                    sb.append(d);
                    remainingSum -= d;
                    break;
                }
            }
        }

        return sb.toString();
    }
}