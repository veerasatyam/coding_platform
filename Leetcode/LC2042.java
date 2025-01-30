class Solution {
    public boolean areNumbersAscending(String s) {
        String[] tokens = s.split(" ");
        int current = -1;

        for (String token : tokens) {
            if (isNumber(token)) {
                int num = Integer.parseInt(token);
                if (num <= current) {
                    return false;
                }
                current = num;
            }
        }
        
        return true;
    }

    private boolean isNumber(String token) {
        for (char c : token.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
