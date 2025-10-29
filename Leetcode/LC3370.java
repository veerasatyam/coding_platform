class Solution {
    public int smallestNumber(int n) {
        int res = 1;
        while(n>res){
            res = (res<<1) | 1;
        }
        return res;
    }
}


//binary serach approach 

class Solution {
    public int smallestNumber(int n) {
        int low = 1, high = 31;
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            int val = (1 << mid) - 1;

            if (val >= n) {
                ans = val;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
