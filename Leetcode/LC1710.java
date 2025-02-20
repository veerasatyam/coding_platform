class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int n = boxTypes.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (boxTypes[j][1] < boxTypes[j + 1][1]) {
                    int tempBoxes = boxTypes[j][0];
                    int tempUnits = boxTypes[j][1];

                    boxTypes[j][0] = boxTypes[j + 1][0];
                    boxTypes[j][1] = boxTypes[j + 1][1];

                    boxTypes[j + 1][0] = tempBoxes;
                    boxTypes[j + 1][1] = tempUnits;
                }
            }
        }

        int maxUnits = 0;
        
        for (int i = 0; i < n; i++) {
            int boxCount = Math.min(boxTypes[i][0], truckSize);
            maxUnits += boxCount * boxTypes[i][1]; 
            truckSize -= boxCount; 
            
            if (truckSize == 0) break;
        }
        
        return maxUnits;
    }
}
