class Solution {
    public boolean hasSameDigits(String s) {
        StringBuilder str = new StringBuilder(s);
        
        while (str.length() > 2) {
            StringBuilder next = new StringBuilder();
            for (int i = 1; i < str.length(); i++) {
                int a = str.charAt(i - 1) - '0';
                int b = str.charAt(i) - '0';
                int sum = (a + b) % 10;
                next.append(sum);
            }
            str = next;
        }
        return str.charAt(0) == str.charAt(1);
    }
}
