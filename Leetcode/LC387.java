class Solution {
    public int firstUniqChar(String s) {
        int a = -1;
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (i == s.lastIndexOf(x) && s.indexOf(x) == i) {
                a = i;
                break;
            }
        }
        return a;
    }
}

// import java.util.HashMap;
// import java.util.LinkedList;
// import java.util.Queue;

// public class Solution {
//     public int firstUniqChar(String s) {
//         HashMap<Character, Integer> frequencyMap = new HashMap<>();
//         Queue<Character> queue = new LinkedList<>();
        
//         for (int i = 0; i < s.length(); i++) {
//             char c = s.charAt(i);
//             frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
//             queue.offer(c);
            
//             while (!queue.isEmpty() && frequencyMap.get(queue.peek()) > 1) {
//                 queue.poll();
//             }
//         }
        
//         if (queue.isEmpty()) {
//             return -1;
//         } else {
//             char firstUnique = queue.peek();
//             for (int i = 0; i < s.length(); i++) {
//                 if (s.charAt(i) == firstUnique) {
//                     return i;
//                 }
//             }
//             return -1;
//         }
//     }
// }