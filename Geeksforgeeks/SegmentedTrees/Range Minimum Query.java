class GfG {
    static int st[];
    public static int[] constructST(int arr[], int n) {
        st = new int[n * 4];
        build(0, 0,n - 1,arr);
        return st;
    }
    private static void build(int node, int l, int r, int[] arr) {
        if (l == r) {
            st[node] = arr[l];
            return;
        }
        int mid = (l + r) / 2;
        build(2 * node + 1, l, mid, arr);
        build(2 * node + 2, mid + 1, r, arr);
        st[node] = Math.min(st[2*node+1],st[2*node+2]);
    }
    public static int RMQ(int st[], int n, int l, int r) {
        return query(0,0,n-1,l,r);
    }
    private static int query(int node, int l, int r, int ql, int qr) {
        if (qr < l || ql > r) return Integer.MAX_VALUE;
        if (ql <= l && r <= qr) return st[node];
        int mid = (l + r) / 2;
        int x = query(2 * node + 1, l, mid, ql, qr);
        int y = query(2 * node + 2, mid + 1, r, ql, qr);
        return Math.min(x, y);
    }
}