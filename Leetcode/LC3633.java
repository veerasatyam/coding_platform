class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            int landFinishTime = landStartTime[i] + landDuration[i];
            for(int j = 0;j<m;j++){
                int waterFinshTime = waterStartTime[j] + waterDuration[j];
                int landAndWater = Math.max(landFinishTime, waterStartTime[j]) + waterDuration[j];
                int waterAndLand = Math.max(waterFinshTime,landStartTime[i]) + landDuration[i];
                ans = Math.min(ans, Math.min(landAndWater,waterAndLand));
            }
        }
        return ans;
    }
}

// optimal solutioin
class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int ans = Integer.MAX_VALUE;
        // first land and then water
        int minLandFinishTime = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            minLandFinishTime = Math.min(minLandFinishTime, landStartTime[i] + landDuration[i]);
        }
        for(int j = 0;j < m;j++){
            ans = Math.min(ans, Math.max(minLandFinishTime, waterStartTime[j]) + waterDuration[j]);
        }

        // first water and then land
        int minWaterFinishTime = Integer.MAX_VALUE;
        for(int j = 0;j<m;j++){
            minWaterFinishTime = Math.min(minWaterFinishTime, waterStartTime[j] + waterDuration[j]);
        }
        for(int i = 0;i < n;i++){
            ans = Math.min(ans, Math.max(minWaterFinishTime, landStartTime[i]) + landDuration[i]);
        }
        return ans;
    }
}