// brute force approach
class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder str = new StringBuilder();
        int count = 0;
        while(str.length() < b.length()){
            str.append(a);
            count++;
        }
        if(str.indexOf(b) != -1) return count;
        str.append(a);
        if(str.indexOf(b) != -1) return count + 1;
        return -1;
    }
}

// Expected appraoch using rabin karp algorithm
class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder str = new StringBuilder();
        int count = 0;
        while(str.length() < b.length()){
            str.append(a);
            count++;
        }
        if(rabinKarp(str.toString(),b)) return count;
        str.append(a);
        if(rabinKarp(str.toString(),b)) return count + 1;
        return -1;
    }
    private boolean rabinKarp(String text,String pattern){
        int n = text.length();
        int m = pattern.length();
        if(m > n) return false;
        int base = 26;
        int mod = 1000000007;
        long patternHash = 0;
        long textHash = 0;
        long power = 1;
        for(int i = 0;i < m - 1; i++) power = (power * base) % mod;
        for(int i =0; i < m; i++){
            patternHash = (patternHash * base + pattern.charAt(i)) % mod;
            textHash = (textHash * base + text.charAt(i)) % mod;
        }
        for(int i = 0; i<= n - m; i++){
            if(patternHash == textHash){
                if(text.substring(i,i+m).equals(pattern)) return true;
            }
            if(i < n - m){
                textHash = (textHash - text.charAt(i)*power % mod + mod) % mod;
                textHash = (textHash * base + text.charAt(i + m)) % mod;
            }
        }
        return false;
    }
}