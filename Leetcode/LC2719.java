class Solution {
    void updateSegmentTree(int node,int l,int r,int idx,long[] tree){
        if(l==r){
            tree[node] = 1;
            return;
        }
        int mid = (l + r) / 2;
        if(idx <= mid) updateSegmentTree(2*node + 1,l,mid,idx,tree);
        else updateSegmentTree(2*node + 2,mid + 1,r,idx,tree);
        tree[node] = tree[2*node + 1] + tree[2*node + 2];
    }
    private long querySegementTree(int node,int ql,int qr,int l,int r,long[] tree){
        if(ql > r || qr < l) return 0;
        if(l >= ql && r <= qr) return tree[node];
        int mid = (l + r) / 2;
        long left = querySegementTree(2*node + 1, ql, qr, l, mid, tree);
        long right = querySegementTree(2*node + 2, ql, qr, mid + 1, r, tree);
        return left + right;
    }
    
    public long goodTriplets(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums1.length;
        for(int i = 0;i<n;i++) map.put(nums2[i],i);

        // segmented Tree Code
        long[] tree = new long[4*n]; // updates are based on the nums[2]
        long result = 0;
        updateSegmentTree(0,0,n-1,map.get(nums1[0]),tree); // marking the first node in nums1[0] as visited

        for(int i = 1;i<n;i++){
            int idx = map.get(nums1[i]);

            long leftCommonCount = querySegementTree(0, 0, idx, 0, n-1, tree);
            long leftNotCommonCount = i - leftCommonCount;
            
            long elementsAfterIdxNums2 = (n-1) - idx;
            long rightCommonCount = elementsAfterIdxNums2 - leftNotCommonCount;

            result += leftCommonCount * rightCommonCount;
            
            updateSegmentTree(0, 0, n-1, idx, tree);
        }
        return result;
    }
}