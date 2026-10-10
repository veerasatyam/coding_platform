class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
       int k = k1 + k2;
       int n = nums1.length;
       long ans = 0;
       PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
       for(int i = 0; i < n; i++){
           pq.add(Math.abs(nums1[i] - nums2[i]));
       }
       while(k > 0 && !pq.isEmpty()){
           int x = pq.poll();
           if(x == 0) break;
           x--;
           pq.add(x);
           k--;
       }
        while(!pq.isEmpty()){
              int x = pq.poll();
              ans += (long)x * (long)x;
        }
         return ans;
    }
}

// optimal solution by storing the frequency of the difference in a map and then reducing the difference from the highest to lowest until k is exhausted.

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = (long) k1 + k2;
        long ans = 0;

        int[] map = new int[100001];
        int n = nums1.length;

        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            map[diff]++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        for (int diff = 0; diff < map.length; diff++) {
            if (map[diff] > 0) {
                pq.add(new int[]{diff, map[diff]});
            }
        }

        while (k > 0 && !pq.isEmpty()) {
            int[] top = pq.poll();
            int diff = top[0];
            int freq = top[1];

            if (diff == 0) {
                pq.add(top);
                break;
            }

            int min = (int) Math.min(k, (long) freq);
            k -= min;

            if (min == freq) {
                pq.add(new int[]{diff - 1, freq});
            } else {
                pq.add(new int[]{diff, freq - min});
                pq.add(new int[]{diff - 1, min});
            }
        }

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            long diff = top[0];
            long freq = top[1];
            ans += diff * diff * freq;
        }

        return ans;
    }
}



// most optimal using counting sort approach 
//Approach-2 (Using Counting Sort)
//T.C : O(n + maxDiff), maxDiff <= 10^5
//S.C : O(n)
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;

        int[] diff = new int[n];
        int maxDiff = 0;
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
        }
        int[] countDiff = new int[maxDiff + 1];
        for (int d : diff)  countDiff[d]++;
        long K = (long) k1 + k2;

        for (int currDiff = maxDiff; currDiff > 0 && K > 0; currDiff--) {
            int countOps = (int) Math.min(countDiff[currDiff], K);
            countDiff[currDiff] -= countOps;
            countDiff[currDiff - 1] += countOps;
            K -= countOps;
        }

        long result = 0;
        for (long d = 1; d <= maxDiff; d++) {
            result += countDiff[(int) d] * d * d;
        }
        return result;
    }
}