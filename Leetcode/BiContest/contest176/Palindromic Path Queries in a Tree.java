/// this soluution is not completed
class Solution {
    class Pair{
        int node;
        char ch;
        public Pair(int node, char ch){
            this.node = node;
            this.ch = ch;
        }
    }
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new Pair(edge[1], s.charAt(edge[0])));
            graph.get(edge[1]).add(new Pair(edge[0], s.charAt(edge[1])));
        }
        List<Boolean> result = new ArrayList<>();
        for (String query : queries) {
            String[] parts = query.split(" ");
            if(parts[0].equals("update")){
                int node = Integer.parseInt(parts[1]);
                char newChar = parts[2].charAt(0);
                graph.get(node).ch = newChar;
                continue;
            }
            int u = Integer.parseInt(parts[1]);
            int v = Integer.parseInt(parts[2]);
            result.add(isPalindromePath(graph, s, u, v));
        }
        return result;
    }
    private boolean isPalindromePath(List<List<Pair>> graph, String s, int u, int v) {
        boolean[] visited = new boolean[graph.size()];
        List<Character> pathChars = new ArrayList<>();
        dfs(graph, s, u, v, visited, pathChars);
        return isPalindrome(pathChars);
    }
    private void dfs(List<List<Pair>> graph, String s, int current, int target, boolean[] visited, List<Character> pathChars) {
        if (current == target) {
            pathChars.add(s.charAt(current));
            return;
        }
        visited[current] = true;
        pathChars.add(s.charAt(current));
        for (Pair neighbor : graph.get(current)) {
            if (!visited[neighbor.node]) {
                dfs(graph, s, neighbor.node, target, visited, pathChars);
                if (pathChars.get(pathChars.size() - 1) == s.charAt(current)) {
                    return;
                }
            }
        }
        pathChars.remove(pathChars.size() - 1);
    }
    private boolean isPalindrome(List<Character> chars) {
        int left = 0, right = chars.size() - 1;
        while (left < right) {
            if (chars.get(left) != chars.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}