// pure recursion
class Solution {
    List<Integer> res = new ArrayList<>();
    public int[] validSequence(String word1, String word2) {
        if(helper(word1, word2, 0, 0, false)){
            int[] ans = new int[res.size()];
            for(int i=0;i<res.size();i++){
                ans[i] = res.get(i);
            }
            return ans;
        }
        return new int[0];
    }
    private boolean helper(String word1,String word2,int i,int j,boolean changed){
        if(j == word2.length()) return true;
        if(i == word1.length()) return false;
        if(word1.charAt(i) == word2.charAt(j)){
            res.add(i);
            if(helper(word1,word2,i+1,j+1,changed)) return true;
            res.remove(res.size()-1);
        }
        if(!changed){
            res.add(i);
            if(helper(word1,word2,i+1,j+1,true)) return true;
            res.remove(res.size()-1);
        }
        if(helper(word1,word2,i+1,j,changed)) return true;
        return false;
    }
}

// recursion + memoization
class Solution {
    List<Integer> res = new ArrayList<>();
    public int[] validSequence(String word1, String word2) {
        HashMap<String,Integer> map = new HashMap<>();
        if(helper(word1, word2, 0, 0, false,map)){
            int[] ans = new int[res.size()];
            for(int i=0;i<res.size();i++){
                ans[i] = res.get(i);
            }
            return ans;
        }
        return new int[0];
    }
    private boolean helper(String word1,String word2,int i,int j,boolean changed,HashMap<String,Integer> map){

        if(j == word2.length()) return true;
        if(i == word1.length()) return false;
        String key = i + "," + j + "," + changed;
        if(map.containsKey(key)) return map.get(key) == 1;
        if(word1.charAt(i) == word2.charAt(j)){
            res.add(i);
            if(helper(word1,word2,i+1,j+1,changed,map)) {
                map.put(key,1);
                return true;
            }
            res.remove(res.size()-1);
        }
        if(!changed){
            res.add(i);
            if(helper(word1,word2,i+1,j+1,true,map)){
                map.put(key,1);
                return true;
            }
            res.remove(res.size()-1);
        }
        if(helper(word1,word2,i+1,j,changed,map)){
            map.put(key,1);
            return true;
        }
        map.put(key,0);
        return false;
    }
}



// The above solutions will give TLE for large inputs. Below is the optimized solution using greedy approach. The idea is to match the characters from the right side of word1 and word2 and store the length of the matched characters in an array. Then we can iterate through word1 and word2 and check if we can form word2 by using the matched characters and at most one modification.
import java.util.*;

class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] rightHandSideMatchLength = new int[n];
        int rightMatched = 0;
        int i = n - 1;
        int j = m - 1;
        while (i >= 0) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                rightMatched++;
                j--;
            }
            rightHandSideMatchLength[i] = rightMatched;
            i--;
        }
        List<Integer> seq = new ArrayList<>();
        boolean changePower = true;
        i = 0;
        j = 0;
        while (i < n && j < m) {
            if (word1.charAt(i) == word2.charAt(j)) {
                seq.add(i);
                j++;
            }
            else if (changePower && i + 1 < n && rightHandSideMatchLength[i + 1] >= m - j - 1) {
                seq.add(i);
                j++;
                changePower = false;
            }
            i++;
        }
        if (j != m) return new int[0];
        int[] ans = new int[seq.size()];
        for (int k = 0;k < seq.size();k++) ans[k] = seq.get(k);
        return ans;
    }
}