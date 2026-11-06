class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs,(a,b)-> a[1] - b[1]);
        int m = queries.length;
        int[] ans = new int[m];
        int[][] sortedQueries = new int[m][2];
        for(int i = 0; i < m; i++){
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a,b)-> a[0] - b[0]);
        int[] serverCount = new int[n + 1];
        int activeSer = 0;
        int left = 0;
        int right = 0;
        for(int i = 0; i < m; i++){
            int qtime = sortedQueries[i][0];
            int qidx = sortedQueries[i][1];

            int windowS = qtime - x;
            int windowE = qtime;
            while(right < logs.length && logs[right][1] <= windowE){
                int serverId = logs[right][0];
                if(serverCount[serverId] == 0){
                    activeSer++;
                }
                serverCount[serverId]++;
                right++;
            }
            while(left < right && logs[left][1] < windowS){
                int serverId = logs[left][0];
                serverCount[serverId]--;
                if(serverCount[serverId] == 0){
                    activeSer--;
                }
                left++;
            }
            ans[qidx] = n - activeSer;
        }
        return ans;
     }
}