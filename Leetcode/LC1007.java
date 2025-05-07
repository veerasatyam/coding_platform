// class Solution {
//     public int minDominoRotations(int[] tops, int[] bottoms) {
//         int a = tops[0], b = bottoms[0];
//         int n = tops.length;
//         boolean possibleA = true, possibleB = true;

//         for (int i = 0; i < n; i++) {
//             if (tops[i] != a && bottoms[i] != a) {
//                 possibleA = false;
//                 break;
//             }
//         }

//         for (int i = 0; i < n; i++) {
//             if (tops[i] != b && bottoms[i] != b) {
//                 possibleB = false;
//                 break;
//             }
//         }

//         if (!possibleA && !possibleB) {
//             return -1;
//         }

//         int topRotationsA = 0, topRotationsB = 0;
//         if (possibleA) {
//             for (int i = 0; i < n; i++) {
//                 if (tops[i] != a) {
//                     topRotationsA++;
//                 }
//             }
//         }
//         if (possibleB) {
//             for (int i = 0; i < n; i++) {
//                 if (tops[i] != b) {
//                     topRotationsB++;
//                 }
//             }
//         }

//         int bottomRotationsA = 0, bottomRotationsB = 0;
//         if (possibleA) {
//             for (int i = 0; i < n; i++) {
//                 if (bottoms[i] != a) {
//                     bottomRotationsA++;
//                 }
//             }
//         }
//         if (possibleB) {
//             for (int i = 0; i < n; i++) {
//                 if (bottoms[i] != b) {
//                     bottomRotationsB++;
//                 }
//             }
//         }

//         int minRotations = Integer.MAX_VALUE;
//         if (possibleA) {
//             minRotations = Math.min(minRotations, Math.min(topRotationsA, bottomRotationsA));
//         }
//         if (possibleB) {
//             minRotations = Math.min(minRotations, Math.min(topRotationsB, bottomRotationsB));
//         }

//         return minRotations == Integer.MAX_VALUE ? -1 : minRotations;
//     }
// }


class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int a = find(tops, bottoms, tops[0]);
        if(a != -1)
            return a;
        return find(tops, bottoms, bottoms[0]);
    }
    
    int find(int[] tops, int[] bottoms, int target) {
        int flipTop = 0;
        int flipBottom = 0;
        int n = tops.length;

        for(int i = 0; i < n; i++) {
            if(tops[i] != target && bottoms[i] != target)
                return -1;
            else if(tops[i] != target) {
                flipTop++;
            } else if(bottoms[i] != target) {
                flipBottom++;
            }
        }
        return Math.min(flipTop, flipBottom);
    }
}