import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = A.length;
        int[] ans = new int[n];
        for(int i = 0;i<n;i++){
            map.put(A[i],map.getOrDefault(A[i],0) + 1);
            map.put(B[i],map.getOrDefault(B[i],0) + 1);
            ans[i] = count(map);
        }
        return ans;
    }
    private int count(Map<Integer,Integer> map){
        int c = 0;
        for(int a : map.keySet()){
            if(map.get(a) == 2) c++;
        }
        return c;
    }
}

// better solution 
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] ans = new int[A.length];
        int[] freq = new int[A.length + 1];
        int common = 0;
        for(int i = 0; i < A.length; i++){
            freq[A[i]]++;
            if(freq[A[i]] == 2){
                common++;
            }
            freq[B[i]]++;
            if(freq[B[i]] == 2){
                common++;
            }
            ans[i] = common;
        }
        return ans;
    }
}