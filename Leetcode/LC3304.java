class Solution {
    public char kthCharacter(int k) {
        StringBuilder ans = new StringBuilder();
        ans.append('a');
        while (ans.length() < k) {
            int n = ans.length();
            for (int i = 0; i < n && ans.length() < k; i++) {
                char nextChar = (char)(ans.charAt(i) + 1);
                ans.append(nextChar);
            }
        }
        return ans.charAt(k - 1);
    }
}
