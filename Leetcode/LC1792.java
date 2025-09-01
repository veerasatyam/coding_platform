class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        for (int[] c : classes) {
            int pass = c[0], total = c[1];
            pq.add(new double[]{gain(pass, total), pass, total});
        }
        while (extraStudents-- > 0) {
            double[] top = pq.poll();
            int pass = (int) top[1];
            int total = (int) top[2];
            pass++;
            total++;
            pq.add(new double[]{gain(pass, total), pass, total});
        }
        double sum = 0.0;
        while (!pq.isEmpty()) {
            double[] curr = pq.poll();
            sum += (double) curr[1] / curr[2];
        }
        return sum / classes.length;
    }
    
    private double gain(int pass, int total) {
        return (double)(pass + 1) / (total + 1) - (double) pass / total;
    }
}
