class Solution {
    public boolean sumGame(String num) {
        int leftKnownSum = 0;
        int rightKnownSum = 0;
        int leftQnMarkCount = 0;
        int rightQnMarkCount = 0;
        int n = num.length();
        int i = 0;
        int j = n-1;
        while(i < j){
            if(num.charAt(i) != '?') leftKnownSum += num.charAt(i) - '0';
            else leftQnMarkCount++;
            if(num.charAt(j) != '?') rightKnownSum += num.charAt(j) - '0';
            else rightQnMarkCount++;
            i++;
            j--;
        }
        int totalQnMarks = leftQnMarkCount + rightQnMarkCount;
        if (totalQnMarks % 2 == 1) {
            return true;
        }
        int LEFT = 2 * leftKnownSum + 9 * leftQnMarkCount;
        int RIGHT = 2 * rightKnownSum + 9 * rightQnMarkCount;
        if (LEFT == RIGHT) {
            return false;
        }
        return true;
    }
}