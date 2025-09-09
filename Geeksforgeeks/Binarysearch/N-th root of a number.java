class Solution {
    public int nthRoot(int n, int m) {
        if(n==1) return m;
        if(m==0) return 0;
        int low = 1,high=m;
        while(low<=high){
            int mid =(low+high)/2;
            int value = solve(mid,n,m);
            if(value==m) return mid;
            else if(value>m) high = mid -1;
            else low = mid+1;
        }
        return -1;
    }
    private int solve(int base,int expo,int limit){
        int result = 1;
        while(expo!=0){
            result = result*base;
            expo--;
            if(result>limit) return result;
        }
        return result;
    }
}