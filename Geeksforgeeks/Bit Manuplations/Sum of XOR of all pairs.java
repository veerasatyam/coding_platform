class Solution {
    public long sumXOR(int[] arr) {
        // code here
        long sum  = 0;
        int n = arr.length;
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                sum += arr[i] ^ arr[j];
            }
        }
        return sum;
    }
}


class Solution {
    public long sumXOR(int[] arr) {
        long sum = 0;
        for (int i = 0;i<32;i++){
            int zc = 0, oc = 0; 
            for (int j = 0;j<arr.length;j++){
                if ((arr[j] >> i & 1) == 1) oc++;
                else zc++;
            }
            sum += (long) oc * zc * (1 << i); 
        }
        return sum;
    }
}