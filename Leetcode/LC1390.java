class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for(int a : nums)sum += findDivisors(a);
        return sum;
    }
    private int findDivisors(int n){
        int x = n;
        int sum = 0;
        List<Integer> ls = new ArrayList<>();
        for(int i=1;i*i<=n;i++){
            if(x%i==0){
                ls.add(i);
                if(i != x/i) ls.add(x/i);
            }
        }
        for(int a : ls) sum += a;
        return ls.size() == 4? sum : 0;
    }
}