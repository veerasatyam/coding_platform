// brute force approach
class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = tasks.length;
        int[] ans = new int[shifts.length];
        int current = 0;
        int done = 0;
        for(int i = 0; i < shifts.length;i++){
            int time = shifts[i];
            while(current < n && time > 0){
                int need = tasks[current] - done;
                if(time >= need){
                    time = time - need;
                    current++;
                    done = 0;
                }else{
                    done += time;
                    time = 0;
                }
            }
            if(current == n){
                ans[i] = 0;
                current = 0;
                done = 0;
            }else{
                ans[i] = n - current;
            }
        }
        return ans;
    }
}

// optimal using prefix sum and binary search
class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = tasks.length;
        long[] prefix = new long[n];
        prefix[0] = tasks[0];
        for (int i = 1; i < n; i++) prefix[i] = prefix[i - 1] + tasks[i];
        int[] ans = new int[shifts.length];
        long prevDone = 0;
        long total = prefix[n - 1];
        for (int i = 0; i < shifts.length; i++) {
            long time = shifts[i];
            prevDone += time;
            if (prevDone >= total) {
                ans[i] = 0;
                prevDone = 0;
            } else {
                int index = BinarySearch(prefix, prevDone);
                ans[i] = n - index - 1;
            }
        }
        return ans;
    }

    private int BinarySearch(long[] prefix, long target) {
        int low = 0, high = prefix.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (prefix[mid] <= target) low = mid + 1;
            else high = mid - 1;
        }
        return high;
    }
}