class Solution {
    public int[] scoreValidator(String[] events) {
        int n = events.length;
        int counter = 0;
        int total = 0;
        int i = 0;
        while (counter < 10 && i < n) {
            String x = events[i];
            if (x.equals("W"))counter++;
            else if (x.equals("WD") || x.equals("NB"))total++;
            else if (Character.isDigit(x.charAt(0)))total += x.charAt(0) - '0';
            i++;
        }
        return new int[]{total, counter};
    }
}