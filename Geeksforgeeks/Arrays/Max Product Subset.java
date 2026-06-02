class Solution {
    final int mod = (int)1e9 + 7;
    public int findMaxProduct(int[] arr) {
        long ans = helper(arr, 0, 1L, false);
        return (int) ans;
    }
    private long helper(int[] arr,int index,long product, boolean taken) {
        if (index == arr.length)return taken ? product : Long.MIN_VALUE;
        long include = helper(arr,index + 1,product * arr[index],true);
        long exclude = helper(arr,index + 1,product,taken);
        return Math.max(include,exclude) % mod;
    }
}


// optimal solution
class Solution {
    public int findMaxProduct(int[] arr) {
        int n = arr.length;
        if (n == 1) return arr[0];
        long ans = 1;
        int mod = (int)1e9 + 7;
        int zeroCount = 0, negCount = 0;
        int maxNeg = Integer.MIN_VALUE, idxMaxNeg = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                zeroCount++;
            } 
            else if (arr[i] < 0) {
                negCount++;
                if (idxMaxNeg == -1 || arr[i] > maxNeg) {
                    maxNeg = arr[i];
                    idxMaxNeg = i;
                }
            }
        }
        if (zeroCount == n) return 0;
        if (negCount == 1 && zeroCount == n - 1) return 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) continue;
            if (negCount % 2 == 1 && i == idxMaxNeg) continue;
            ans = ((ans * arr[i]) % mod + mod) % mod;
        }
        return (int)ans;
    }
}