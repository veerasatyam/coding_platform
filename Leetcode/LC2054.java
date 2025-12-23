// as we already sorting the array by starting time.Think like try to find the first index of start value which is more than the curr starting value , so that the upcomming events never overlap with the current and you can try to find the max value in that range , to optimise this we use suffixSum to store the max value from that index to the last 

class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events,(a,b)->Integer.compare(a[0],b[0]));
        int[] suffixSum = new int[events.length];
        suffixSum[n-1] = events[n-1][2];
        for(int i=n-2;i>=0;i--){
            suffixSum[i] = Math.max(suffixSum[i+1],events[i][2]);
        }
        int ans = 0;        
        for(int[] event : events){
            int s = event[0];
            int e = event[1];
            int value = event[2];
            ans = Math.max(ans,value);
            int idx = binarySearch(events,e);
            if(idx < n){
                ans = Math.max(ans,value+suffixSum[idx]);
            }
        }
        return ans;
    }
    private int binarySearch(int[][] events,int end){
        int l = 0,h = events.length-1;
        int ans = events.length;
        while(l<=h){
            int mid = (l+h)/2;
            if(events[mid][0] > end){
                ans = mid;
                h = mid -1 ;
            }else{
                 l = mid + 1;
            }
        }
        return ans;
    }
}