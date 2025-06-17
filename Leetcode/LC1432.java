class Solution {
    public static int maxDiff(int num) {
       String s = String.valueOf(num);
        String maxStr = s;
        for (char ch : s.toCharArray()) {
            if (ch != '9') {
                maxStr = s.replace(ch, '9');
                break;
            }
        }
        String minStr = s;
        char firstChar = s.charAt(0);
        if (firstChar != '1') {
            minStr = s.replace(firstChar, '1');
        } else {
            for (int i = 1; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch != '0' && ch != firstChar) {
                    minStr = s.replace(ch, '0');
                    break;
                }
            }
        }

        int a = Integer.parseInt(maxStr);
        int b = Integer.parseInt(minStr);
        return a - b;
    }
}