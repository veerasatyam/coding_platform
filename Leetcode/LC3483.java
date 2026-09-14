class Solution {
    public int totalNumbers(int[] digits) {
        int count = 0;
        int n = digits.length;
        boolean[] used = new boolean[1000];
        for(int i = 0; i < n; i++){
            if(digits[i] == 0) continue;
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                for(int k = 0; k < n; k++){
                    if(i == k || j == k) continue;
                    int x = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if(x % 2 == 0 && !used[x]) count++;
                    used[x] = true;
                }
            }
        }
        return count;
    }
}


// optimal solution
class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];
        for(int d : digits) freq[d]++;
        int count = 0;
        for(int i = 1; i <= 9; i++){
            if(freq[i] == 0) continue;
            freq[i]--;
            for(int j = 0; j <= 9; j++){
                if(freq[j] == 0) continue;
                freq[j]--;
                for(int k = 0; k <= 8; k += 2){
                    if(freq[k] == 0) continue;
                    count++;
                }
                freq[j]++;
            }
            freq[i]++;
        }
        return count;
    }
}