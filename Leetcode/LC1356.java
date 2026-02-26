class Solution {
    public int[] sortByBits(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < 32; i++) {
            list.add(new ArrayList<>());
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            int c = count(arr[i]);
            list.get(c).add(arr[i]);
        }
        for(List<Integer> x : list) {
            Collections.sort(x);
            ans.addAll(x);
        }
       int[] res = new int[arr.length];
       int i = 0;
       for(int x : ans) {
           res[i++] = x;
       }
       return res;
    }
    private int count(int n){
        int x = n;
        int c = 0;
        while(x > 0){
            int a = x & 1;
            if(a==1) c++;
            x = x >> 1;
        }
        return c;
    }
}

// another solution
class Solution {
    public int[] sortByBits(int[] arr) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0]; 
                return a[1] - b[1];
            }
        );

        for(int i=0;i<arr.length;i++){
            int num = count_bits(arr[i]);
            pq.offer(new int[]{num, arr[i]});
        }

        int index = 0;
        while (!pq.isEmpty()) {
            arr[index++] = pq.poll()[1]; 
        }

        return arr;
    }

    public int count_bits(int n){
        int x = n;
        int c = 0;
        while(x > 0){
            int a = x & 1;
            if(a==1) c++;
            x = x >> 1;
        }
        return c;
    }
}