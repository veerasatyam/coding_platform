class Solution {
    class Pair {
        int index;
        int jumps;
        
        Pair(int index, int jumps) {
            this.index = index;
            this.jumps = jumps;
        }
    }
    public int minJumps(int[] arr) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            adj.add(new ArrayList<>());
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                adj.get(i).add(i - 1);
            }
            if (i < arr.length - 1) {
                adj.get(i).add(i + 1);
            }
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0));
        boolean[] visited = new boolean[arr.length];
        visited[0] = true;
        // adj building
        for (List<Integer> indices : map.values()) {
            for (int i = 0; i < indices.size(); i++) {
                for (int j = i + 1; j < indices.size(); j++) {
                    adj.get(indices.get(i)).add(indices.get(j));
                    adj.get(indices.get(j)).add(indices.get(i));
                }
            }
        }
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            int index = pair.index;
            int jumps = pair.jumps;
            if (index == arr.length - 1) {
                return jumps;
            }
            for (int neighbor : adj.get(index)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new Pair(neighbor, jumps + 1));
                }
            }
        }
        return -1;
    }
}



// optimal appraoch
class Solution {
    public int minJumps(int[] arr) {
        if (arr.length == 1) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        boolean[] visited = new boolean[arr.length];
        visited[0] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0], jumps = curr[1];
            if (i == arr.length - 1) return jumps;

            if (i - 1 >= 0 && !visited[i - 1]) {
                visited[i - 1] = true;
                queue.offer(new int[]{i - 1, jumps + 1});
            }
            if (i + 1 < arr.length && !visited[i + 1]) {
                visited[i + 1] = true;
                queue.offer(new int[]{i + 1, jumps + 1});
            } 
            List<Integer> sameVals = map.get(arr[i]);
            if (sameVals != null) {
                for (int j : sameVals) {
                    if (!visited[j]) {
                        visited[j] = true;
                        queue.offer(new int[]{j, jumps + 1});
                    }
                }
                map.remove(arr[i]);
            }
        }
        return -1;
    }
}