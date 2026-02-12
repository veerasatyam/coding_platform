class Solution {
    public int longestBalanced(String s) {
        if(s.length()==0) return 0;
        int[] frequency = new int[26];
        int n = s.length();
        int max = 1;
        for(int i=0;i<n;i++){
            frequency[s.charAt(i)-'a']++;
            for(int j=i+1;j<n;j++){
                frequency[s.charAt(j)-'a']++;
                if(balanced(frequency)) max = Math.max(max,j-i+1);
            }
            Arrays.fill(frequency,0);
        }
        return max;
    }
    private boolean balanced(int[] arr){
        int prev = -1;
        for(int i : arr){
            if(i==0) continue;
            if(prev==-1) prev = i;
            if(prev != i) return false;
        }
        return true;
    }
}