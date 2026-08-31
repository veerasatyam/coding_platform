// **Lazy Propagation – Key Points**

// * Used in segment trees to handle **efficient range updates**
// * Avoids updating all elements in a range immediately
// * Introduces an extra array called **lazy[]** to store pending updates

// **Why we use it**

// * Normal range update can take **O(n)** time in worst case
// * Lazy propagation reduces update time to **O(log n)**
// * Prevents repeated and unnecessary updates

// **How it works**

// * Store pending updates in **lazy[]** instead of applying instantly
// * When visiting a node:

//   * First apply any pending updates (propagation)
// * For complete overlap:

//   * Update current node
//   * Mark children as lazy (defer update)
// * For partial overlap:

//   * Push lazy updates down
//   * Recurse on children

// **Key idea**

// * “Do work only when needed” (delay updates until required)

// **Benefits**

// * Efficient for problems with:

//   * Frequent range updates
//   * Frequent range queries
// * Maintains overall complexity:

//   * Update → **O(log n)**
//   * Query → **O(log n)**

// Related problmes : leetcode 307 
public class SegmentTreeLazy {
    int[] seg;
    int[] lazy;
    int n;

    public SegmentTreeLazy(int[] arr) {
        n = arr.length;
        seg = new int[4 * n];
        lazy = new int[4 * n];
        build(0, 0, n - 1, arr);
    }

    // Build segment tree
    private void build(int node, int l, int r, int[] arr) {
        if (l == r) {
            seg[node] = arr[l];
            return;
        }
        int mid = (l + r) / 2;
        build(2 * node + 1, l, mid, arr);
        build(2 * node + 2, mid + 1, r, arr);
        seg[node] = seg[2 * node + 1] + seg[2 * node + 2];
    }

    // Propagate lazy updates
    private void propagate(int node, int l, int r) {
        if (lazy[node] != 0) {
            seg[node] += (r - l + 1) * lazy[node];

            if (l != r) {
                lazy[2 * node + 1] += lazy[node];
                lazy[2 * node + 2] += lazy[node];
            }
            lazy[node] = 0;
        }
    }

    // Range update: add val to [ql, qr]
    public void update(int ql, int qr, int val) {
        update(0, 0, n - 1, ql, qr, val);
    }

    private void update(int node, int l, int r, int ql, int qr, int val) {
        propagate(node, l, r);

        // No overlap
        if (r < ql || l > qr) return;

        // Complete overlap
        if (l >= ql && r <= qr) {
            lazy[node] += val;
            propagate(node, l, r);
            return;
        }

        // Partial overlap
        int mid = (l + r) / 2;
        update(2 * node + 1, l, mid, ql, qr, val);
        update(2 * node + 2, mid + 1, r, ql, qr, val);
        seg[node] = seg[2 * node + 1] + seg[2 * node + 2];
    }

    // Range query: sum of [ql, qr]
    public int query(int ql, int qr) {
        return query(0, 0, n - 1, ql, qr);
    }

    private int query(int node, int l, int r, int ql, int qr) {
        propagate(node, l, r);

        // No overlap
        if (r < ql || l > qr) return 0;

        // Complete overlap
        if (l >= ql && r <= qr) return seg[node];

        // Partial overlap
        int mid = (l + r) / 2;
        return query(2 * node + 1, l, mid, ql, qr) +
               query(2 * node + 2, mid + 1, r, ql, qr);
    }

    // Demo
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};

        SegmentTreeLazy st = new SegmentTreeLazy(arr);

        System.out.println(st.query(1, 3)); // sum [1,3]

        st.update(1, 5, 10); // add 10 to range [1,5]

        System.out.println(st.query(1, 3)); // updated sum
    }
}