class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        generate(1, n, k, new ArrayList<>());
        return result;
    }
    void generate(int start, int n, int k, List<Integer> curr) {
        if (curr.size() == k) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i <= n; i++) {
            curr.add(i);
            generate(i + 1, n, k, curr); 
            curr.remove(curr.size() - 1);
        }
    }
}
