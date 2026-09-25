class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<Integer> fhalf = new PriorityQueue<>();
        PriorityQueue<Integer> lhalf = new PriorityQueue<>();
        
        long cost = 0;
        int i = 0;
        int j = n - 1;
        for (int x = 0; x < candidates; x++) {
            if (i <= j) {
                fhalf.add(costs[i++]);
            }
            if (i <= j) {
                lhalf.add(costs[j--]);
            }
        }
        for (int x = 0; x < k; x++) {
            while (fhalf.size() < candidates && i <= j) {
                fhalf.add(costs[i++]);
            }
            while (lhalf.size() < candidates && i <= j) {
                lhalf.add(costs[j--]);
            }
            
            int a = fhalf.isEmpty() ? Integer.MAX_VALUE : fhalf.peek();
            int b = lhalf.isEmpty() ? Integer.MAX_VALUE : lhalf.peek();
            if (a <= b) {
                cost += a;
                fhalf.poll();
            } else {
                cost += b;
                lhalf.poll();
            }
        }
        
        return cost;
    }
}