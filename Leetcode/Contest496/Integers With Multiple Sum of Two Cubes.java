class Solution {
    public List<Integer> findGoodIntegers(int n) {
        int[] freq = new int[n+1];
        int limit = (int) Math.cbrt(n);
        for(int a = 1;a<=limit;a++){
           int a3 = a*a*a;
            for(int b = a;b<=limit;b++){
                int b3 = b*b*b;
                if(a3 + b3 > n) break;
                freq[a3 + b3]++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 1;i<=n;i++) if(freq[i] >= 2) result.add(i);
        Collections.sort(result);
        return result;
    }
}


// the above code will show TLE
import java.util.*;

class Solution {
    public List<Integer> findGoodIntegers(int n) {
        Map<Integer, Integer> freq = new HashMap<>();
        int limit = (int) Math.cbrt(n);
        for (int a = 1;a<=limit;a++) {
            int a3 = a*a*a;
            for (int b = a;b<=limit;b++) {
                int sum = a3 + b*b*b;
                if (sum > n) break;
                freq.put(sum,freq.getOrDefault(sum,0) + 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int key : freq.keySet()) {
            if (freq.get(key) >= 2) {
                result.add(key);
            }
        }
        Collections.sort(result);
        return result;
    }
}