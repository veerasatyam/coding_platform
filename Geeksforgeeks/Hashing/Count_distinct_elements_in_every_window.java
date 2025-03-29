import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
       ArrayList<Integer> result = new ArrayList<>();
       HashMap<Integer, Integer> hm = new HashMap<>();
       
       for (int i = 0; i < k; i++) {
           hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
       }
       
       result.add(hm.size());
       
       for (int i = 1; i <= arr.length - k; i++) {
           hm.put(arr[i - 1], hm.getOrDefault(arr[i - 1], 0) - 1);
           if (hm.get(arr[i - 1]) == 0) {
               hm.remove(arr[i - 1]);
           }
           
           hm.put(arr[i + k - 1], hm.getOrDefault(arr[i + k - 1], 0) + 1);
           
           result.add(hm.size());
       }
       
       return result;
    }
}
