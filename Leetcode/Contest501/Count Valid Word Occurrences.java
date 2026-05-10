class Solution {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        StringBuilder sb = new StringBuilder();
        for (String chunk : chunks) sb.append(chunk);
        String s = sb.toString();
        Map<String, Integer> freq = new HashMap<>();
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (!Character.isLowerCase(s.charAt(i))) {
                i++;
                continue;
            }
            int start = i;
            int j = i;
            while (j < n) {
                char ch = s.charAt(j);
                if (Character.isLowerCase(ch)) {
                    j++;
                }
                else if(ch == '-' && j > start && j + 1 < n && Character.isLowerCase(s.charAt(j - 1)) && Character.isLowerCase(s.charAt(j + 1))) j++;
                else {
                    break;
                }
            }
            String word = s.substring(start, j);
            freq.put(word, freq.getOrDefault(word, 0) + 1);
            i = j;
        }
        int[] ans = new int[queries.length];
        for (int k = 0;k < queries.length;k++)ans[k] = freq.getOrDefault(queries[k], 0);
        

        return ans;
    }
}