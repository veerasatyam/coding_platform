// class Solution {
//     public boolean isPrefixString(String s, String[] words) {
//         StringBuilder str = new StringBuilder();
//         for(String a : words){
//             str.append(a);
//             if(s.equals(str.toString())) return true;
//         }
//         return false;
//     }
// }


class Solution {
    public boolean isPrefixString(String s, String[] words) {
        int i = 0;
        for (String w : words) {
            for (char c : w.toCharArray()) {
                if (i == s.length() || s.charAt(i) != c) {
                    return false;
                }
                i++;
            }
            if (i == s.length()) {
                return true;
            }
        }
        return false;
    }
}
