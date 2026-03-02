class Solution {
    public int minOperations(String s) {
        int one = ExpectedOne(s);
        int zero = ExpectedZero(s);
        return Math.min(one,zero);
    }
    private int ExpectedOne(String s){
        int count = 0;
        for(int i =0;i<s.length();i++){
            if((s.charAt(i)-'0') != (i%2)) count++;
        }
        return count;
    }
    private int ExpectedZero(String s){
        int count = 0;
        for(int i =0;i<s.length();i++){
            if((s.charAt(i)-'0') != ((i+1)%2)) count++;
        }
        return count;
    }
}

// expected interview approach
class Solution {
    public int minOperations(String s) {
        int strtWithOne = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)-'0' == (i%2)) strtWithOne++;
        }
        return Math.min(strtWithOne, s.length()-strtWithOne);
    }
}