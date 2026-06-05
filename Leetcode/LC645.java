class Solution {
    public int[] findErrorNums(int[] nums) {
     int dup = -1, missing = -1;
    for (int x : nums) {
        int idx = Math.abs(x) - 1;
        if (nums[idx] < 0) dup = Math.abs(x);
        else nums[idx] *= -1;
    }
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] > 0) missing = i + 1;
    }
    return new int[]{dup, missing};
    }
}


class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2];
        int[] freq = new int[n+1];
        for(int i=0;i<n;i++){
            freq[nums[i]]++;
        }
        for(int i=1;i<=n;i++){
            if(freq[i]==2){
                ans[0]=i;
            }
            if(freq[i]==0){
                ans[1]=i;
            }
        }
        return ans;
    }
}


// using math
class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        long sum = 0;
        long sumofn = 1L*n*(n+1)/2;
        for(int i = 0;i < n;i++)sum += nums[i];
        long sumofsq = 1L*n*(n+1)*(2L*n+1)/6;
        long sumofsqn = 0;
        for(int i = 0;i < n;i++)sumofsqn += 1L*nums[i]*nums[i];
        long diff = sum - sumofn;
        long diffsq = sumofsqn - sumofsq;
        long sumofnum = diffsq/diff;
        int missing = (int)((sumofnum - diff)/2);
        int dup = (int)(missing + diff);
        return new int[]{dup, missing};
    }
}


// using bit manipulation
class Solution {
    public int[] findErrorNums(int[] nums){
        int n = nums.length;
        int xor = 0;
        for(int i = 0;i < n;i++){
            xor ^= nums[i];
            xor ^= (i + 1);
        }
        int bitNo = 0;
        while(true){
            if((xor & (1 << bitNo)) != 0)break;
            bitNo++;
        }
        int zero = 0, one = 0;
        for(int i = 0;i < n;i++){
            if((nums[i] & (1 << bitNo)) != 0)one ^= nums[i];
            else zero ^= nums[i];
        }
        for(int i = 1;i <= n;i++){
            if((i & (1 << bitNo)) != 0)one ^= i;
            else zero ^= i;
        }
        for(int i = 0;i < n;i++){
            if(nums[i] == zero)return new int[]{zero, one};
        }
        return new int[]{one, zero};
    }
}