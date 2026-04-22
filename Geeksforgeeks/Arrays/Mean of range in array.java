class Solution {
    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for(int i = 1;i<n;i++) prefix[i] = prefix[i-1] + arr[i];
        for(int[] q : queries){
            int l = q[0];
            int r = q[1];
            int sum = prefix[r] - ((l > 0) ? prefix[l-1] : 0);
            int len  = r - l + 1;
            result.add(sum / len);
        }
        return result;
    }
}




// using segmented trees
class Solution {
    class sTree{
        int[] tree;
        private sTree(int n,int[] arr){
            tree = new int[4*n];
            buildTree(0,0,n-1,arr);
        }
        private void buildTree(int node,int l,int r,int[] arr){
            if(l == r){
                tree[node] = arr[l];
                return;
            }
            int mid = (l + r) / 2;
            buildTree(2*node + 1,l,mid,arr);
            buildTree(2*node + 2,mid + 1,r,arr);
            tree[node] = tree[2*node + 1] + tree[2*node + 2]; 
        }
        private int querySum(int node,int l,int r,int ql,int qr){
            if(qr < l || ql > r) return 0;
            if(qr >= r && ql <= l) return tree[node];
            int mid = (l + r) / 2;
            int left = querySum(2*node + 1, l, mid, ql, qr);
            int right = querySum(2*node + 2, mid + 1, r, ql, qr);
            return left + right;
        }
    }
    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        sTree t = new sTree(n,arr);
        for(int[] q : queries){
            int l = q[0];
            int r = q[1];
            int sum = t.querySum(0,0,n-1,l,r);
            int len = r - l + 1;
            result.add(sum / len);
        }
        return result;
    }
}