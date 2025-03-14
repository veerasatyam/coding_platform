class Solution {
    public int rowWithMax1s(int arr[][]) {
        int n = arr[0].length;
        int maxRow = -1;
        int maxCount = 0;
        int j = n - 1;

        for (int i = 0; i < arr.length; i++) {
            while (j >= 0 && arr[i][j] == 1) {
                j--;
            }

            int onesInRow = n - j - 1;

            if (onesInRow > maxCount) {
                maxCount = onesInRow;
                maxRow = i;
            }
        }

        return maxRow;
    }
}