// approach: brute force 
class Solution {
    public int minFlips(String s) {
        String str = s + s;
        int n = s.length();
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            String x = str.substring(i, i+n);
            int f1 = countFlips(x, '0');
            int f2 = countFlips(x, '1');
            ans = Math.min(ans, Math.min(f1, f2));
        }
        return ans;
    }
    private int countFlips(String s, char start){
        int count = 0;
        char expected = start;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != expected) count++;
            expected = (expected=='0')?'1':'0';
        }
        return count;
    }
}


// approach 2 : sliding window
class Solution {
    public int minFlips(String s) {
        String str = s + s;
        int n = s.length();
        int ans = Integer.MAX_VALUE;
        int f1 = 0, f2 = 0;
        for(int i = 0;i<n;i++){
            char p1 = (i%2==0) ? '0' : '1';
            char p2 = (i%2==0) ? '1' : '0';
            if(str.charAt(i) != p1) f1++;
            if(str.charAt(i) != p2) f2++;
        }
        ans = Math.min(ans, Math.min(f1, f2));
        for(int i = n; i < 2 * n; i++){
            char p1 = (i % 2 == 0) ? '0' : '1';
            char p2 = (i % 2 == 0) ? '1' : '0';
            if(str.charAt(i) != p1) f1++;
            if(str.charAt(i) != p2) f2++;
            int j = i - n;
            char prev1 = (j % 2 == 0) ? '0' : '1';
            char prev2 = (j % 2 == 0) ? '1' : '0';
            if(str.charAt(j) != prev1) f1--;
            if(str.charAt(j) != prev2) f2--;
            ans = Math.min(ans, Math.min(f1, f2));
        }

        return ans;
    }
}

// appraoch 3 : finding the flips using 2 separate loops
class Solution {
    public int minFlips(String s) {

        int n = s.length();
        String str = s + s;
        int ans = Integer.MAX_VALUE;
        // for 01010101
        int f1 = 0;
        char expected = '0';

        for(int i = 0; i < 2*n; i++){
            if(str.charAt(i) != expected) f1++;
            expected = (expected=='0')?'1':'0';
            if(i >= n){
                char prev = (i-n)%2==0 ? '0' : '1';
                if(str.charAt(i-n) != prev) f1--;
            }
            if(i >= n-1){
                ans = Math.min(ans, f1);
            }
        }
        // for 10101010
        int f2 = 0;
        expected = '1';
        for(int i = 0; i < 2*n; i++){
            if(str.charAt(i) != expected) f2++;
            expected = (expected=='0')?'1':'0';
            if(i >= n){
                char prev = (i-n)%2==0 ? '1' : '0';
                if(str.charAt(i-n) != prev) f2--;
            }
            if(i >= n-1){
                ans = Math.min(ans, f2);
            }
        }
        return ans;
    }
}