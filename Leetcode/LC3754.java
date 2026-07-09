class Solution {
    public long sumAndMultiply(int n) {
        String s = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c != '0') sb.append(c);
        }
        if (sb.length() == 0) return 0;
        long x = Long.parseLong(sb.toString());
        long sum = 0;
        String xStr = String.valueOf(x);
        for (char c : xStr.toCharArray()) sum += (c - '0');
        return x * sum;
    }
}


class Solution {
    public long sumAndMultiply(int n) {
        long num=0;
        long sum=0;
        long ans =0;
        while(n!=0){
            if(n%10!=0){
                num = num*10+n%10;
                sum += n%10;
            }
            n/=10;
        }
         while(num!=0){
            ans = ans*10+num%10;
            num/=10;
        }
        return ans*sum;
    }
}