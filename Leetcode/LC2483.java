class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] prefix = new int[n];
        prefix[0] = customers.charAt(0)=='Y'?1:-1;
        int max = -1; 
        int best = 0;
        for (int i=0;i<n;i++) {
            if (i>0) prefix[i] = prefix[i-1]+(customers.charAt(i)=='Y'? 1:-1);
            if (prefix[i]>max) {
                max = prefix[i];
                best = i+1;
            }
        }
        if(max==0) return 0;
        return best;
    }
}



class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] prefixN = new int[n+1];
        int[] suffixY = new int[n+1];
        for (int i=1;i<=n;i++)prefixN[i] = prefixN[i-1]+(customers.charAt(i-1)=='N'?1:0);
        for (int i = n - 1; i >= 0; i--) suffixY[i]=suffixY[i + 1]+(customers.charAt(i)=='Y'?1:0);
        int best=0;
        int minPenalty=Integer.MAX_VALUE;
        for (int i=0;i<=n;i++) {
            int penalty=prefixN[i]+suffixY[i];
            if (penalty<minPenalty) {
                minPenalty=penalty;
                best = i;
            }
        }
        return best;
    }
}
