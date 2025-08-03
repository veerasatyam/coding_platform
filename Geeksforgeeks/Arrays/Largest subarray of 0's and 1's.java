class Solution {
    public int maxLen(int[] arr) {
       Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLen = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] == 0 ? -1 : 1;
            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return maxLen;
    }
}