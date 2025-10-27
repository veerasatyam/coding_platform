class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0;
        int n = bank.length;
        int m = bank[0].length();
        int total = 0;
        for(int i=0;i<n;i++){
            int curr = 0;
            for(int j=0;j<m;j++){
                if(bank[i].charAt(j)=='1') curr++;
            }
            total += (prev*curr);
            if(curr!=0) prev = curr;
        }
        return total;
    }
}