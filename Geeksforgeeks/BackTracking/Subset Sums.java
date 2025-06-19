import java.util.ArrayList;
import java.util.List;

class Solution {
    public ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        calculateSum(0, 0, arr, result);
        return result;
    }

    void calculateSum(int sum, int i, int[] arr, List<Integer> result) {
        if (i == arr.length) {
            result.add(sum);
            return;
        }
        calculateSum(sum + arr[i], i + 1, arr, result);
        calculateSum(sum, i + 1, arr, result);
    }
}
