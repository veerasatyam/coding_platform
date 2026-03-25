// User function Template for Java

class Solution {
    class st{
        int[] tree;
        st(int n,int[] arr){
            tree = new int[n*4];
            build(0,0,n-1,arr);
        }
        public void build(int node,int l,int r,int[] arr){
            if(l==r){
                tree[node] = arr[l];
                return;
            } 
            int mid = (l + r) / 2;
            build(2*node + 1,l,mid,arr);
            build(2*node + 2,mid+1,r,arr);
            tree[node] = tree[2*node + 1] + tree[2*node + 2];
        }
        public int Range(int node,int l,int r,int ql,int qr){
            if (r < ql || l > qr) return 0;
            if (l >= ql && r <= qr) return tree[node];
            int mid = (l + r)/2;
            return Range(2*node + 1,l,mid,ql,qr) + Range(2*node + 2,mid + 1, r,ql,qr);
        }
    }
    List<Integer> querySum(int n, int arr[], int q, int queries[]) {
            List<Integer> result = new ArrayList<>();
            st x = new st(n, arr);
            int i = 0;
            while (q-- > 0) {
                int a = queries[i++];
                int b = queries[i++];
                result.add(x.Range(0, 0, n - 1, a - 1, b - 1));
            }

            return result;
        }
 }