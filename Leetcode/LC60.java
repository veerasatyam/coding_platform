class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        for(int i = 1;i < n; i++){
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);
        StringBuilder ans = new StringBuilder();
        k = k - 1;
        while (true) {
            ans.append(numbers.get(k / fact));
            numbers.remove(k / fact);
            if(numbers.isEmpty()) break;
            k = k % fact;
            fact = fact / numbers.size();
        }
        return ans.toString();
    }
}


// brute force
import java.util.*;

class Solution {
    // Function to generate all possible permutations of a string
    private void permutationHelper(StringBuilder s, int index, List<String> res) {
        if (index == s.length()) {
            res.add(s.toString());
            return;
        }
        for (int i = index; i < s.length(); i++) {
            // Swap and recurse
            s.swap(i, index);
            permutationHelper(s, index + 1, res);
            s.swap(i, index);  // backtrack
        }
    }

    public String getPermutation(int n, int k) {
        StringBuilder s = new StringBuilder();
        List<String> res = new ArrayList<>();
        
        // Create string with characters '1' to 'n'
        for (int i = 1; i <= n; i++) {
            s.append(i);
        }

        permutationHelper(s, 0, res);  // Generate all permutations
        Collections.sort(res);  // Sort the generated permutations
        
        // Make k 0-based indexed to point to kth sequence
        return res.get(k - 1);
    }
}

public class Main {
    public static void main(String[] args) {
        int n = 3, k = 3;
        Solution obj = new Solution();
        String ans = obj.getPermutation(n, k);
        System.out.println("The Kth permutation sequence is " + ans);
    }
}

