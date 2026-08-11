class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[1] - b[1]);
        int count = 0;
        int lastEnd = Integer.MIN_VALUE;
        for(int[] in : intervals){
            int start = in[0];
            int end = in[1];
            if(lastEnd <= start){
                lastEnd = end;
            }else{
                count++;
            }
        }
        return count;
    }
}