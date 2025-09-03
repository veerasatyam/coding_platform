// class Solution {
//     public int countPrefixes(String[] words, String s) {
//         int count = 0;
//         for (String a : words) {
//             if (a.length() > s.length()) continue;
//             boolean isPrefix = true;
//             for (int i = 0; i < a.length(); i++) {
//                 if (a.charAt(i) != s.charAt(i)) {
//                     isPrefix = false;
//                     break;
//                 }
//             }
//             if (isPrefix) count++;
//         }
//         return count;
//     }
// }

//optimised version
class Solution {
    public int countPrefixes(String[] words, String s) {
        int count = 0;
        for (String a : words) {
            if (a.length() <= s.length() && s.startsWith(a)) {
                count++;
            }
        }
        return count;
    }
}
