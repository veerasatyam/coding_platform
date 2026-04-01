class Solution {
    // Returns a vector<int> of size 2 where:
    // [0] = minimum value in arr from index L to R (inclusive),
    // [1] = maximum value in arr from index L to R (inclusive).
    // Uses the prebuilt segTree where each node stores [min, max].
    // Segment tree indexing:
    // - For a node at idx, left child is at 2*idx + 1, right child at 2*idx + 2.
    public int[] getMinMax(int[] arr, int L, int R, int[][] segTree) {
        // code here
        return queryRange(0, 0, arr.length-1,L,R,segTree);
    }
    private int[] queryRange(int node,int l,int r,int ql,int qr,int[][] segTree){
         if (qr < l || r < ql) return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE};
         if(l >= ql && r <= qr) return segTree[node];
         int mid = (l + r) / 2;
         int[] left = queryRange(2*node + 1,l,mid,ql,qr,segTree);
         int[] right = queryRange(2*node + 2,mid + 1,r,ql,qr,segTree);
         int[] result = new int[2];
         result[0] = Math.min(left[0],right[0]);
         result[1] = Math.max(left[1],right[1]);
         return result;
    }

    // Updates the value at arr[index] to 'value' and updates the segTree accordingly.
    // Uses the prebuilt segTree where each node stores [min, max].
    // Segment tree indexing:
    // - For a node at idx, left child is at 2*idx + 1, right child at 2*idx + 2.
    public void updateValue(int[] arr, int index, int value, int[][] segTree) {
        update(0,0,arr.length - 1,index,value,segTree);
    }
    private void update(int node,int l,int r,int idx,int val,int[][] segTree){
        if(l==r){
            segTree[node][0] = val;
            segTree[node][1] = val;
            return;
        }
        int mid = (l + r) / 2;
        if(mid >= idx) update(2*node + 1,l,mid,idx,val,segTree);
        else update(2*node + 2,mid + 1,r,idx,val,segTree);
        segTree[node][0] = Math.min(segTree[2*node + 1][0] , segTree[2*node + 2][0]);
        segTree[node][1] = Math.max(segTree[2*node + 1][1] , segTree[2*node + 2][1]);
    }
};