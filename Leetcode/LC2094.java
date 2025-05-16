import java.util.*;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> result = new TreeSet<>();
        int[] count = new int[10];

        for (int digit : digits) {
            count[digit]++;
        }

        for (int num = 100; num <= 998; num += 2) {
            int d1 = num / 100;
            int d2 = (num / 10) % 10;
            int d3 = num % 10;

            int[] tempCount = new int[10];
            tempCount[d1]++;
            tempCount[d2]++;
            tempCount[d3]++;

            boolean isValid = true;
            for (int i = 0; i < 10; i++) {
                if (tempCount[i] > count[i]) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                result.add(num);
            }
        }

        int[] resArr = new int[result.size()];
        int i = 0;
        for (int num : result) {
            resArr[i++] = num;
        }

        return resArr;
    }
}
