class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        int n = a.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0;i < n;i++) {
            for (int j = 0;j < n;j++) {
                int currSum = a[i] + b[j];
                if (pq.size() < k) {
                    pq.offer(currSum);
                } else if (currSum > pq.peek()) {
                    pq.poll();
                    pq.offer(currSum);
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) res.add(pq.poll());
        Collections.reverse(res);
        return res;
    }
}


class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        int n = a.length;
        Arrays.sort(a);
        Arrays.sort(b);
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        HashSet<String> seen = new HashSet<>();
        reverse(a);
        reverse(b);
        pq.offer(new int[]{a[0] + b[0], 0, 0});
        seen.add("0,0");
        ArrayList<Integer> res = new ArrayList<>();
        while (res.size() < k && !pq.isEmpty()) {
            int[] top = pq.poll();
            int sum = top[0], i = top[1], j = top[2];
            res.add(sum);
            if (i + 1 < n && !seen.contains((i + 1) + "," + j)) {
                pq.offer(new int[]{a[i + 1] + b[j], i + 1, j});
                seen.add((i + 1) + "," + j);
            }
            if (j + 1 < n && !seen.contains(i + "," + (j + 1))) {
                pq.offer(new int[]{a[i] + b[j + 1], i, j + 1});
                seen.add(i + "," + (j + 1));
            }
        }
        return res;
    }
    private static void reverse(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r){
            int temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }
}