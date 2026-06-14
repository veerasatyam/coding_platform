import java.util.*;
// brute force
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            int maxLeft = 0;
            int maxRight = 0;
            for (int j = 0; j <= i; j++) {
                if (height[j] > maxLeft) {
                    maxLeft = height[j];
                }
            }
            for (int j = i; j < n; j++) {
                if (height[j] > maxRight) {
                    maxRight = height[j];
                }
            }
            totalWater += Math.min(maxLeft, maxRight) - height[i];
        }
        return totalWater;
    }
}


// using prefix and suffix max
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        prefixMax[0] = height[0];
        suffixMax[n-1] = height[n-1];
        for(int i = 1; i < n; i++) prefixMax[i] = Math.max(prefixMax[i-1],height[i]);
        for(int i = n - 2; i >= 0; i--) suffixMax[i] = Math.max(suffixMax[i + 1],height[i]);
        int total = 0;
        for(int i = 0; i < n; i++){
            if(prefixMax[i] > height[i] && suffixMax[i] > height[i]){
                total += Math.min(prefixMax[i],suffixMax[i]) - height[i];
            }
        }
        return total;
    }
}


// only using sufixSum
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] suffixMax = new int[n];
        int leftMax = height[0];
        suffixMax[n-1] = height[n-1];
        for(int i = n - 2; i >= 0; i--) suffixMax[i] = Math.max(suffixMax[i + 1],height[i]);
        int total = 0;
        for(int i = 0; i < n; i++){
            if(leftMax > height[i] && suffixMax[i] > leftMax){
                total += Math.min(leftMax,suffixMax[i]) - height[i];
            }
            leftMax = Math.max(leftMax,height[i]);
        }
        return total;
    }
}


// space optimisation 
class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }
}