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
    private void build(int idx, int low, int high, int[] arr) {
        if (low == high) {
            seg[idx] = arr[low];
            return;
        }
        int mid = (low + high) / 2;
        build(2 * idx + 1, low, mid, arr);
        build(2 * idx + 2, mid + 1, high, arr);
        seg[idx] = seg[2 * idx + 1] + seg[2 * idx + 2];
    }

    // Propagate lazy updates
    private void propagate(int idx, int low, int high) {
        if (lazy[idx] != 0) {
            seg[idx] += (high - low + 1) * lazy[idx];

            if (low != high) {
                lazy[2 * idx + 1] += lazy[idx];
                lazy[2 * idx + 2] += lazy[idx];
            }
            lazy[idx] = 0;
        }
    }

    // Range update: add val to [l, r]
    public void update(int l, int r, int val) {
        update(0, 0, n - 1, l, r, val);
    }

    private void update(int idx, int low, int high, int l, int r, int val) {
        propagate(idx, low, high);

        // No overlap
        if (high < l || low > r) return;

        // Complete overlap
        if (low >= l && high <= r) {
            lazy[idx] += val;
            propagate(idx, low, high);
            return;
        }

        // Partial overlap
        int mid = (low + high) / 2;
        update(2 * idx + 1, low, mid, l, r, val);
        update(2 * idx + 2, mid + 1, high, l, r, val);
        seg[idx] = seg[2 * idx + 1] + seg[2 * idx + 2];
    }

    // Range query: sum of [l, r]
    public int query(int l, int r) {
        return query(0, 0, n - 1, l, r);
    }

    private int query(int idx, int low, int high, int l, int r) {
        propagate(idx, low, high);

        // No overlap
        if (high < l || low > r) return 0;

        // Complete overlap
        if (low >= l && high <= r) return seg[idx];

        // Partial overlap
        int mid = (low + high) / 2;
        return query(2 * idx + 1, low, mid, l, r) +
               query(2 * idx + 2, mid + 1, high, l, r);
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