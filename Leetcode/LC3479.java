class Solution {
    int[] tree;
    void constructTree(int n, int[] baskets){
        tree = new int[4 * n];
        build(0, 0, n - 1, baskets);
    }
    private void build(int node, int l, int r, int[] baskets){
        if(l == r){
            tree[node] = l;
            return;
        }
        int mid = (l + r) / 2;
        build(2*node + 1, l, mid, baskets);
        build(2*node + 2, mid + 1, r, baskets);
        int left = tree[2*node + 1];
        int right = tree[2*node + 2];
        tree[node] = (baskets[left] >= baskets[right]) ? left : right;
    }

    private void update(int node, int l, int r, int idx, int[] baskets){
        if(l == r){
            baskets[idx] = -1;
            tree[node] = idx;
            return;
        }

        int mid = (l + r) / 2;
        if(idx <= mid) update(2*node + 1, l, mid, idx, baskets);
        else update(2*node + 2, mid + 1, r, idx, baskets);
        int left = tree[2*node + 1];
        int right = tree[2*node + 2];
        tree[node] = (baskets[left] >= baskets[right]) ? left : right;
    }
    private int query(int node, int l, int r, int val, int[] baskets){
        if(baskets[tree[node]] < val) return -1;
        if(l == r){
            return l;
        }
        int mid = (l + r) / 2;
        int leftIdx = tree[2*node + 1];
        if(baskets[leftIdx] >= val){
            return query(2*node + 1, l, mid, val, baskets);
        } else {
            return query(2*node + 2, mid + 1, r, val, baskets);
        }
    }

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        constructTree(n, baskets);
        int unplaced = 0;
        for(int i = 0; i < n; i++){
            int idx = query(0, 0, n - 1, fruits[i], baskets);
            if(idx == -1){
                unplaced++;
            } else {
                update(0, 0, n - 1, idx, baskets);
            }
        }
        return unplaced;
    }
}