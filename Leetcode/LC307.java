// without using Lazy propagation i.e normal approach
class NumArray {
    int[] tree;
    int n;
    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[4*n];
        build(0,0,n-1,nums);
    }
    private void build(int node, int l, int r, int[] nums){
        if(l == r){
            tree[node] = nums[l];
            return;
        }
        int mid = (l + r) / 2;
        build(2*node + 1, l, mid, nums);
        build(2*node + 2, mid + 1, r, nums);
        tree[node] = tree[2*node + 1] + tree[2*node + 2];
    }

    public void update(int index, int val) {
        updateQuery(0,0,n-1,index,val);
    }

    private void updateQuery(int node, int l, int r, int index, int val){
        if(l == r){
            tree[node] = val;
            return;
        }
        int mid = (l + r) / 2;
        if(index <= mid) updateQuery(2*node + 1,l,mid,index,val);
        else updateQuery(2*node + 2,mid + 1,r,index,val);
        tree[node] = tree[2*node + 1] + tree[2*node + 2];
    }
    public int sumRange(int left, int right) {
        return range(0, 0, n-1, left, right);
    }
    private int range(int node, int l, int r, int ql, int qr){
        if(r < ql || l > qr) return 0;
        if(ql <= l && r <= qr) return tree[node];
        int mid = (l + r) / 2;
        return range(2*node + 1,l,mid,ql,qr) + range(2*node + 2,mid + 1,r,ql,qr);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */