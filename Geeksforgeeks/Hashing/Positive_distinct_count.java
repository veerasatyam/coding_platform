
import java.util.HashSet;

class Solution {
    public int distinctCount(int[] arr) {
        HashSet<Integer> res = new HashSet<>();
        for(int a : arr)
        {
            if(a>0) res.add(a);
        }
        return res.size();
    }
}