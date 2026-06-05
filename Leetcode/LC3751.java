class Solution {
    public int totalWaviness(int num1, int num2) {
        int count = 0;
        for(int i = num1;i <= num2;i++){
            String s = String.valueOf(i);
            int x = waviness(s);
            count += x;
        }
        return count;
    }
    private int waviness(String s){
        int n = s.length();
        int count = 0;
        for(int i = 1;i < n - 1;i++){
            int prev = s.charAt(i - 1) - '0';
            int curr = s.charAt(i) - '0';
            int next = s.charAt(i + 1) - '0';
            if((curr > prev && curr > next) || (curr < prev && curr < next)){
                count++;
            }
        }
        return count;
    }
}



// using math
class Solution {
    public int totalWaviness(int num1, int num2) {
        int count = 0;
        for(int i = num1;i <= num2;i++){
            count += waviness(i);
        }
        return count;
    }
    private int waviness(int n){
        if(n < 100) return 0;
        int count = 0;
        int prev = n % 10;
        n /= 10;
        int curr = n % 10;
        n /= 10;
        while(n > 0){
            int next = n % 10;
            if((curr > prev && curr > next) || (curr < prev && curr < next)){
                count++;
            }
            prev = curr;
            curr = next;
            n /= 10;
        }
        return count;
    }
}