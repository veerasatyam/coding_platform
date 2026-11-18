class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int tank = 0;
            boolean canComplete = true;
            for (int j = 0; j < n; j++) {
                int index = (i + j) % n;
                tank += gas[index] - cost[index];
                if (tank < 0) {
                    canComplete = false;
                    break;
                }
            }

            if (canComplete) {
                return i;
            }
        }

        return -1;
    }
}





class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int tank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];

            tank += gas[i] - cost[i];

            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return totalGas < totalCost ? -1 : start;
    }
}
