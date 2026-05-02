import java.util.*;

class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        double[][] items = new double[val.length][3];
        for (int i = 0; i < val.length; i++) {
            items[i][0] = val[i];                         
            items[i][1] = wt[i];                          
            items[i][2] = (double) val[i] / wt[i];        
        }
        Arrays.sort(items, (a, b) -> Double.compare(b[2],a[2]));
        double total = 0;
        for (double[] item : items) {
            if (item[1] <= capacity) {
                total += item[0];
                capacity -= (int) item[1];
            } else {
                total += capacity * item[2];
                break;
            }
        }
        return total;
    }
}