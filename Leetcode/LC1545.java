// brute force
class Solution {
    public char findKthBit(int n, int k) {
        if(n==1) return '0';
        StringBuilder sb = new StringBuilder("0");
        for(int i = 2;i<=n;i++){
            StringBuilder temp = new StringBuilder(sb);
            sb.append("1");
            sb.append(temp.reverse().toString().replace('0','2').replace('1','0').replace('2','1'));
        }
        return sb.charAt(k-1);
    }
}

// optimal
class Solution{
    public char findKthBit(int n, int k) {
        if(n==1) return '0';
        return helper(n,k);
    }
    private char helper(int n,int k){
        if(n==1) return '0';
        int len = (1<<n) - 1;
        if(k==(len/2)+1) return '1';
        else if(k>len/2+1) return helper(n-1,len-k+1)=='0' ? '1' : '0';
        else return helper(n-1,k);
    }
}