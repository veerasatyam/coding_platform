class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}



// class Solution {
//     public String reverseWords(String s) {
//         s = s.trim();
//         StringBuilder result = new StringBuilder();
//         int i = 0, n = s.length();

//         while (i < n) {
//             while (i < n && s.charAt(i) == ' ') {
//                 i++;
//             }
//             int j = i;
//             while (j < n && s.charAt(j) != ' ') {
//                 j++;
//             }
//             if (i < n) {
//                 if (result.length() > 0) {
//                     result.insert(0, " ");
//                 }
//                 result.insert(0, s.substring(i, j));
//             }
//             i = j;
//         }

//         return result.toString();
//     }
// }
