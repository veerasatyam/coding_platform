class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int INF = 100000000;
        int[][] dist = new int[n][n];
        for (int i=0;i<n;i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for(int[] edge : edges){
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (dist[i][k] == INF) continue;
                for (int j = 0; j < n; j++) {
                    if (dist[k][j] == INF) continue;
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        int minCities = INF;
        int city = -1;
        for(int i = 0; i < n; i++){
            int row = 0;
            for(int j = 0; j < n; j++){
                if(i != j && dist[i][j] <= distanceThreshold) row++;
            }
            if(row<minCities || (row==minCities&&i>city)){
                minCities = row;
                city = i;
            }
        }
        return city;
    }
}