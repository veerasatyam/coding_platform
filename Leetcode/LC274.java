// class Solution {
//     public int hIndex(int[] citations) {
//         Arrays.sort(citations);
//         int n = citations.length;
//         int h = 0;
//         for (int i = 0; i < n; i++) {
//             int possibleH = n - i;
//             if (citations[i] >= possibleH) {
//                 h = possibleH;
//                 break;
//             }
//         }
//         return h;
//     }
// }


// using counting sort technique

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int temp[] = new int[n+1];
        Arrays.fill(temp, 0);
        for(int i: citations){
            if(i>n) temp[n]++;
            else temp[i]++;
        }
        int count=0;
        for(int i=n; i>=0; i--){
            count+=temp[i];
            if(count>=i) return i;
        }
        return -1;
    }
}