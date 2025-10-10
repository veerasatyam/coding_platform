//Recursion
class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
       
        for (int i = 0; i < n; i++)  maxEnergy = Math.max(maxEnergy, helper(energy, k, i));
        return maxEnergy;
    }

    private int helper(int[] energy, int k, int index) {
        if (index >= energy.length) return 0;
        return energy[index] + helper(energy, k, index + k);
    }
}

//Recursion + memorisation

class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n];
        int maxEnergy = Integer.MIN_VALUE;
        Arrays.fill(dp,-1);
        for (int i = 0; i < n; i++)  maxEnergy = Math.max(maxEnergy, helper(dp,energy, k, i));
        return maxEnergy;
    }
    private int helper(int[] dp,int[] energy, int k, int index){
    if(index>=energy.length) return 0;
    if(dp[index]!=-1) return dp[index];
    dp[index] = energy[index] + helper(dp,energy, k, index + k);
    return dp[index];
    }  
}

//tabulation 
class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n];
        int maxEnergy = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (i + k < n)
                dp[i] = energy[i] + dp[i + k];
            else
                dp[i] = energy[i];
            maxEnergy = Math.max(maxEnergy, dp[i]);
        }
        return maxEnergy;
    }
}
