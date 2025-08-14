class Solution {
    public String largestGoodInteger(String num) {
        for (int i = 9; i >= 0; i--) {
            char x = (char) ('0' + i);
            int count = 0;
            for (char a : num.toCharArray()) {
                if (a == x) {
                    count++;
                } else {
                    count = 0;
                }
                if (count == 3) {
                    return String.valueOf(x).repeat(3);
                }
            }
        }
        return "";
    }
}
