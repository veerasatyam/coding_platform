class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int d = Math.abs(i - startIndex);
                int currentMin = Math.min(d, n - d);
                minDistance = Math.min(minDistance, currentMin);
            }
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}