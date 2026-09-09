class Solution {
    public long countCommas(long n) {
        long total = 0;
        long start = 1;
        long len = 1;
        while(start <= n){
            long nextStart = start * 10;
            long end = Math.min(n,nextStart - 1);
            long commas = (len - 1) / 3;
            if(commas > 0){
                long count = (end - start + 1);
                total += count * commas;
            }
            start = nextStart;
            len++;
        }
        return total;
    }
}