// class Solution {
//     public int minimumRecolors(String blocks, int k) {
//         char[] a = blocks.toCharArray();
//         int min = Integer.MAX_VALUE;
        
//         for (int i = 0; i <= a.length - k; i++) { 
//             int count = 0;
//             for (int j = i; j < i + k; j++) { 
//                 if (a[j] == 'W') count++;
//             }
//             min = Math.min(min, count);
//         }
        
//         return min;
//     }
// }
class Solution {
    public int minimumRecolors(String blocks, int k) {
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') count++;
        }
        
        int min = count;

        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i - k) == 'W') count--;
            if (blocks.charAt(i) == 'W') count++;
            min = Math.min(min, count);
        }
        
        return min;
    }
}
