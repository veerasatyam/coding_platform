class Solution {
    static final int mod = 1000000007;

    int n;
    long[] sqSumsegTree;
    long[] sumsegTree;
    long[] lazy;

    void lazyupdate(int node,int l,int r, long val){
        long len = r - l + 1;
        sqSumsegTree[node] += (val *val * len) % mod + (2 * val * sumsegTree[node]) % mod;
        sumsegTree[node] += (val * len) % mod;
        
        if(l != r){
            lazy[node*2 + 1] += val;
            lazy[node*2 + 2] += val;
        }
        lazy[node] = 0;
    }

    void updateRange(int start,int end,int node,int l,int r,long val){
        if(lazy[node] != 0){
            lazyupdate(node,l,r,lazy[node]);
        }
        if(start > r || end < l)  return;
        if(start <= l && r <= end){
            lazyupdate(node,l,r,val);
            return;
        }

        int mid = (l + r) / 2;
        updateRange(start,end,node*2 + 1,l,mid,val);
        updateRange(start,end,node*2 + 2,mid + 1,r,val);

        sqSumsegTree[node] = (sqSumsegTree[node*2 + 1] + sqSumsegTree[node*2 + 2]) % mod;
        sumsegTree[node] = (sumsegTree[node*2 + 1] + sumsegTree[node*2 + 2]) % mod;
    }
    public int sumCounts(int[] nums) {
        n = nums.length;

        sqSumsegTree = new long[4*n];
        sumsegTree = new long[4*n];
        lazy = new long[4*n];

        int[] lastIndex = new int[100001];
        Arrays.fill(lastIndex, -1);
        long totalSum = 0;

        for(int i = 0; i < n; i++){
            int start = lastIndex[nums[i]] + 1;
            int end = i;
            updateRange(start,end, 0, 0, n - 1, 1);

            totalSum += sqSumsegTree[0] % mod;

            lastIndex[nums[i]] = i;
        }
        return (int)(totalSum % mod);
    }
}