
import java.util.HashSet;

class Solution {
    static boolean findsum(int arr[]) {
       int sum=0;
       HashSet<Integer> set = new HashSet<>();
       set.add(0);
       for(int i=0;i<arr.length;i++){
          sum = sum + arr[i];
          if(set.contains(sum)) return true;
          else set.add(sum);
       }
       return false;
    }
}