class Solution {
    boolean[] numbers = new boolean[1000001];
    public long minArraySum(int[] nums) {
        for(int a : nums) numbers[a] = true;
        long sum = 0;
        if(numbers[1] == true) return nums.length;
        for(int i = 0;i < nums.length;i++){
            int x = factors(nums[i]);
            sum += x;
        }
        return sum;
    }
    private int factors(int n){
        List<Integer> factors = new ArrayList<>();
        for (int i = 1;i <= Math.sqrt(n);i++) {
            if (n % i == 0){
                factors.add(i);
                if (i != n/i)factors.add(n / i); 
            }
        }
        Collections.sort(factors);
        for(int a : factors){
            if(numbers[a]) return a;
        }
        return n;
    }
}