class Solution {
    private static int remap(String numStr, char fromDigit, char toDigit) {
        StringBuilder sb = new StringBuilder();
        for (char c : numStr.toCharArray()) {
            sb.append(c == fromDigit ? toDigit : c);
        }
        return Integer.parseInt(sb.toString());
    }
    public int minMaxDifference(int num) {
         String numStr = Integer.toString(num);
        int maxVal = num;
        int minVal = num;

        for (char d : numStr.toCharArray()) {
            if (d != '9') {
                int changed = remap(numStr, d, '9');
                maxVal = Math.max(maxVal, changed);
            }
        }

        for (char d : numStr.toCharArray()) {
            if (d != '0') {
                int changed = remap(numStr, d, '0');
                minVal = Math.min(minVal, changed);
            }
        }

        return maxVal - minVal;
    }
}