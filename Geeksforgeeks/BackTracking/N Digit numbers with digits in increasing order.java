import java.util.*;

class Solution {
    public static ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        int start = (n == 1) ? 0 : 1;
        generate(start, n, new ArrayList<>(), result);
        return result;
    }

    private static void generate(int start, int digitsLeft, List<Integer> current, ArrayList<Integer> result) {
        if (digitsLeft == 0) {
            int num = 0;
            for (int d : current) {
                num = num * 10 + d;
            }
            result.add(num);
            return;
        }

        for (int i = start; i <= 9; i++) {
            current.add(i);
            generate(i + 1, digitsLeft - 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
