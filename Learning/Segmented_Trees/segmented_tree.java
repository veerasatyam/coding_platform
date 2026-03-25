class SegmentTree {
    int[] tree;
    int n;

    SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        build(0, 0, n - 1, arr);
    }

    // Build the tree from array
    void build(int node, int l, int r, int[] arr) {
        if (l == r) {
            tree[node] = arr[l];   // leaf node stores arr[l]
            return;
        }
        int mid = (l + r) / 2;
        build(2 * node + 1, l, mid, arr);       // left child
        build(2 * node + 2, mid + 1, r, arr);   // right child
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2]; // merge
    }

    // Range sum query [ql, qr]
    int query(int node, int l, int r, int ql, int qr) {
        if (qr < l || r < ql) return 0;          // completely outside
        if (ql <= l && r <= qr) return tree[node]; // completely inside
        int mid = (l + r) / 2; 
        return query(2 * node + 1, l, mid, ql, qr)
             + query(2 * node + 2, mid + 1, r, ql, qr);
    }

    // Point update: set arr[idx] = val
    void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            tree[node] = val;
            return;
        }
        int mid = (l + r) / 2;
        if (idx <= mid) update(2 * node + 1, l, mid, idx, val);
        else            update(2 * node + 2, mid + 1, r, idx, val);
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree st = new SegmentTree(arr);

        System.out.println(st.query(0, 0, 5, 1, 3)); // 3+5+7 = 15
        st.update(0, 0, 5, 1, 10);                    // arr[1] = 10
        System.out.println(st.query(0, 0, 5, 1, 3)); // 10+5+7 = 22
    }
}
