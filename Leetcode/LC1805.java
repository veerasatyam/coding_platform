class Solution {
    public int numDifferentIntegers(String word) {
    Set<String> uniqueNumbers = new HashSet<>();
        StringBuilder number = new StringBuilder();
        for (char ch : word.toCharArray()) {
            if (Character.isDigit(ch)) {
                number.append(ch);
            } else {
                if (number.length() > 0) {
                    uniqueNumbers.add(removeLeadingZeros(number.toString()));
                    number.setLength(0);
                }
            }
        }
        if (number.length() > 0) {
            uniqueNumbers.add(removeLeadingZeros(number.toString()));
        }
        return uniqueNumbers.size();
    }

    private static String removeLeadingZeros(String num) {
        int i = 0;
        while (i < num.length() && num.charAt(i) == '0') {
            i++;
        }
        return i == num.length() ? "0" : num.substring(i);
    }
}