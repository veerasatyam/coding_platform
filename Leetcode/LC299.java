// import java.util.HashMap;
// import java.util.HashSet;
// brute force
// class Solution {
//     public String getHint(String secret, String guess) {
//         int cows = 0, bulls = 0;
//         HashMap<Character, Integer> hm = new HashMap<>();
//         HashSet<Integer> hs = new HashSet<>();

//         for (int i = 0; i < secret.length(); i++) {
//             char a = secret.charAt(i);
//             if (a == guess.charAt(i)) {
//                 bulls++;
//                 hs.add(i);
//             } else {
//                 hm.put(a, hm.getOrDefault(a, 0) + 1);
//             }
//         }

//         for (int i = 0; i < guess.length(); i++) {
//             if (hs.contains(i)) continue;
//             char x = guess.charAt(i);
//             if (hm.containsKey(x) && hm.get(x) > 0) {
//                 hm.put(x, hm.get(x) - 1);
//                 cows++;
//             }
//         }

//         return bulls + "A" + cows + "B";
//     }
// }
//optimal solution
class Solution {
    public String getHint(String secret, String guess) {
        int[] count = new int[10];
        int bulls = 0, cows = 0;

        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if (s == g) {
                bulls++;
            } else {
                if (count[s - '0'] < 0) cows++;
                if (count[g - '0'] > 0) cows++;
                count[s - '0']++;
                count[g - '0']--;
            }
        }

        return bulls + "A" + cows + "B";
    }
}
