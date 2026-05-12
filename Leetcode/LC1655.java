class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks,(a,b) ->{
            int x = a[1] - a[0];
            int y = b[1] - b[0];
            return y - x;
        });
        int is = 0;
        int current = 0;
        for(int[] task : tasks){
            int a = task[0];
            int b = task[1];
            if(current < b){
                is = is + b - current;
                current = b;
            }
            current = current - a;
        }
        return is;
    }
}




// binary serach approach 

class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> {
            int x = a[1] - a[0];
            int y = b[1] - b[0];
            return y - x;
        });
        int low = 1;
        int high = 1000000000;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isPossible(tasks, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    private boolean isPossible(int[][] tasks, int energy) {
        for (int[] task : tasks) {
            int actual = task[0];
            int minimum = task[1];
            if (energy < minimum) {
                return false;
            }
            energy -= actual;
        }
        return true;
    }
}