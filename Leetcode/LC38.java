// recursive approach

class Solution {
    public String countAndSay(int n) {
        if (n <= 0) return "";
        return helper(1,n,"1");
    }

    public String helper(int i,int n,String str) {
        if (i == n) return str;
        StringBuilder nStr = new StringBuilder();
        char prev = str.charAt(0);
        int count = 1;
        for (int j = 1;j < str.length();j++) {
            char curr = str.charAt(j);
            if (curr == prev) {
                count++;
            } else {
                nStr.append(count).append(prev);
                prev = curr;
                count = 1;
            }
        }
        nStr.append(count).append(prev);
        return helper(i + 1,n,nStr.toString());
    }
}


// iterative approach 
class Solution {
    public String countAndSay(int n) {
        if (n <= 0) return "";
        String str = "1";
        for(int i = 2; i <= n; i++){
            StringBuilder nStr = new StringBuilder();
            char prev = str.charAt(0);
            int count = 1;
            for (int j = 1;j < str.length();j++) {
                char curr = str.charAt(j);
                if (curr == prev) {
                    count++;
                } else {
                    nStr.append(count).append(prev);
                    prev = curr;
                    count = 1;
                }
            }
            nStr.append(count).append(prev);
            str = nStr.toString();
        }
        return str;
    }
}
