// important question in segmented trees

class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int[] result = new int[queries.length];
        int idx = 0;
        for (int[] q : queries) {
            int a = q[0];
            int b = q[1];
            if(a==b) {
                result[idx++] = a;
                continue;
            }
            if(a<b && heights[a]<heights[b]) {
                result[idx++] = b;
                continue;
            }
            if(b<a && heights[b]<heights[a]) {
                result[idx++] = a;
                continue;
            }
            int find = Math.max(heights[a],heights[b]);
            int x = -1;
            for (int i = Math.max(a,b)+1;i<heights.length;i++) {
                if (heights[i]>find){
                    x = i;
                    break;
                }
            }
            result[idx++] = x;
        }
        return result;
    }
}


// optimal version using segmented Treesclass Solution {
class Solution {
    int[] tree;
    private void ConstructTree(int[] arr,int n){
        tree = new int[4*n];
        build(0,0,n-1,arr);
    }

    private void build(int node,int l,int r,int[] arr){
        if(l == r){
            tree[node] = l;
            return;
        }
        int mid = (l + r) / 2;
        build(2*node + 1,l , mid,arr);
        build(2*node + 2,mid + 1,r,arr);
        int left = tree[2*node + 1];
        int right = tree[2*node + 2];
        tree[node] = arr[left] >= arr[right] ? left : right;
    }

    private int RMIQ(int node,int l,int r,int ql,int qr,int[] heights){
        if(ql > r || qr < l) return Integer.MAX_VALUE;
        if(l >= ql && r <= qr) return tree[node];
        int mid = (l + r) / 2;
        int left = RMIQ(2*node + 1,l,mid,ql,qr,heights);
        int right = RMIQ(2*node + 2,mid+1,r,ql,qr,heights);
        if (left == Integer.MAX_VALUE) return right;
        if (right == Integer.MAX_VALUE) return left;
        return heights[left] >= heights[right] ? left : right;
    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];
        ConstructTree(heights,heights.length);
        int idx = 0;
        for(int[] q : queries){
            int a = q[0];
            int b = q[1];
            if(a == b) {
                result[idx++] = a;
                continue;
            }
            if(a<b && heights[a]<heights[b]) {
                result[idx++] = b;
                continue;
            }
            if(b<a && heights[b]<heights[a]) {
                result[idx++] = a;
                continue;
            }
            int find = Math.max(heights[a],heights[b]);
            int low = Math.max(a,b) + 1;
            int high = heights.length - 1;
            int ans = Integer.MAX_VALUE;
            while(low<=high){
                int mid = (low + high) / 2;
                int pos = RMIQ(0,0,heights.length - 1,low,mid,heights);
                if(pos != Integer.MAX_VALUE && heights[pos] > find){
                    ans = pos;
                    high = mid - 1;
                }else low = mid + 1;
            }
            result[idx++] = ans == Integer.MAX_VALUE? -1 : ans;
        }
        return result;
    }
}


// best time complexity version of code 
// without binary search as well
class Solution {
    static int[] seg;
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n=heights.length;
        seg=new int[4*n];
        build(heights,0,0,n-1);
        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int ai=queries[i][0];
            int bi=queries[i][1];
            if(ai==bi){
                ans[i]=ai;
                continue;
            }
            int left=Math.min(ai,bi);
            int right=Math.max(ai,bi);
            if(heights[right]>heights[left]){
                ans[i]=right;
            }
            else{
                int val=Math.max(heights[ai],heights[bi]);
                ans[i]=query(0,0,n-1,right+1,val);
            }
        }
        return ans;
    }
    public static void build(int[] heights,int indx,int l,int r){
        if(l==r){
            seg[indx]=heights[l];
            return ;
        }
        int mid=l+(r-l)/2;

        build(heights,2*indx+1,l,mid);
        build(heights,2*indx+2,mid+1,r);

        seg[indx]=Math.max(seg[2*indx+1],seg[2*indx+2]);
    }
    public static int query(int indx,int l,int r,int qs,int val){
        if(r<qs || seg[indx]<=val){
            return -1;
        }
        if(l==r){
            return l;
        }
        int mid=l+(r-l)/2;
        if(qs<=mid && seg[2*indx+1]>val){
            int left=query(2*indx+1,l,mid,qs,val);
            if(left!=-1)
            return left;
        }
        return query(2*indx+2,mid+1,r,qs,val);
        
    }
}