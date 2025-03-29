package Binarysearch.BinarySearch;
import java.util.Arrays;

class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);

        int low = 1, high = stalls[stalls.length - 1] - stalls[0]; 
        int ans = 0; 
        
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canPlaceCows(mid, k, stalls)) {   
                ans = mid; 
                low = mid + 1; 
            } else {
                high = mid - 1; 
            }
        }
        return ans;
    }

    private static boolean canPlaceCows(int dis, int k, int[] stalls) {
        int placedCows = 1, lastPlaced = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPlaced >= dis) {
                placedCows++;
                lastPlaced = stalls[i];
            }
            if (placedCows >= k) return true;
        }
        return false;
    }
}
