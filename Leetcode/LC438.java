// class Solution {
//     public List<Integer> findAnagrams(String s, String p) {
//         int k = p.length();
//         List<Integer> result = new ArrayList<>();
//         if (s.length() < k) return result;
//         HashMap<Character, Integer> href = new HashMap<>();
//         for (char c : p.toCharArray()) href.put(c, href.getOrDefault(c, 0) + 1);
//         HashMap<Character, Integer> current = new HashMap<>();
//         for (int i = 0; i < k; i++)  current.put(s.charAt(i), current.getOrDefault(s.charAt(i), 0) + 1);
//         int n = s.length();
//         int i = 0, j = k - 1;
//         while (j < n) {
//             if (current.equals(href)) result.add(i);

//             j++;
//             if (j == n) break;
//             char in = s.charAt(j);
//             current.put(in, current.getOrDefault(in, 0) + 1);

//             char out = s.charAt(i);
//             current.put(out, current.get(out) - 1);
//             if (current.get(out) == 0) current.remove(out);

//             i++;
//         }
//         return result;
//     }
// }


// optimal O(n) Solution

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length(), k = p.length();
        List<Integer> result = new ArrayList<>();
        if (n < k) return result;

        int[] freqP = new int[26];
        int[] window = new int[26];

        for (int i = 0; i < k; i++) {
            freqP[p.charAt(i) - 'a']++;
            window[s.charAt(i) - 'a']++;
        }

        int i = 0, j = k - 1;
        while (j < n) {
            if (matches(freqP, window)) result.add(i);

            j++;
            if (j == n) break;

            window[s.charAt(j) - 'a']++;
            window[s.charAt(i) - 'a']--;
            i++;
        }
        return result;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
