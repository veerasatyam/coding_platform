class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;

        // treating even = + 1 and odd = -1

        int[] currSum = new int[n];
        int maxL = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int r = 0;r<n;r++){
            int val = (nums[r] % 2 == 0) ? 1 : -1;
            int prev = -1;
            if(map.containsKey(nums[r])){
                prev = map.get(nums[r]);
            }
            if(prev != -1){ // we have seen this element in past
                //[0...prev] we are adding (-val) in the past
                for(int l = 0; l <= prev;l++){ // O(n) Range Query Update -Segmenet tree log(n)
                    currSum[l] -= val;
                }
            }
            // [0...r] we are adding val in the range 
            for(int l = 0; l<=r;l++){
                currSum[l] += val;  // O(n) Range Query Update -Segmenet tree log(n)
            }
            // we are finding left most 0 in the range [0....r]
            for(int l = 0; l<= r; l++){
                if(currSum[l] == 0){
                    maxL = Math.max(maxL,r-l+1);// Range Search -- Segment in log(n)
                    break;
                }
            }
            map.put(nums[r],r);
        }
        return maxL;
    }
}

// optimal solution using segmented trees in O(nlogn)

class Solution {
    class segmentTree{
        int[] min,max,lazy;
        int n;
        segmentTree(int n){
            this.n  = n;
            min = new int[4*n];
            max = new int[4*n];
            lazy = new int[4*n];
        }
        void push(int node,int start,int end){
            if(lazy[node] != 0){
                min[node] += lazy[node];
                max[node] += lazy[node];
                if(start != end){
                    lazy[2*node + 1] += lazy[node];
                    lazy[2*node + 2] += lazy[node]; 
                }
                lazy[node] = 0;
            }
        }
        void update(int node,int start,int end,int l,int r,int val){
            push(node,start,end);
            if(r < start || end < l) return;
            if(l <= start && end <= r){
                lazy[node] += val;
                push(node,start,end);
                return;
            }
            int mid = (start +  end) / 2;
            update(2*node + 1,start,mid,l,r,val);
            update(2*node + 2,mid + 1,end,l,r,val);

            min[node] = Math.min(min[2*node + 1],min[2*node + 2]);
            max[node] = Math.max(max[2*node + 1],max[2*node + 2]);
        }
        private int QueryFirstZero(int node,int start,int end){
            push(node,start,end);
            if(min[node] > 0 || max[node] < 0) return -1;
            if(start == end) return start;
            int mid = (start + end) / 2;
            int left = QueryFirstZero(2*node + 1,start,mid);
            if(left != -1) return left;
            return QueryFirstZero(2*node + 2,mid + 1,end);
             
        }
    }
    public int longestBalanced(int[] nums) {
       int n = nums.length;
       segmentTree st = new segmentTree(n);
       Map<Integer,Integer> map = new HashMap<>();
       int maxL = 0;
       for(int r = 0;r < n;r++){
         int val = (nums[r] % 2 == 0) ? 1 : -1;
         if(map.containsKey(nums[r])){
            int prev = map.get(nums[r]);
            st.update(0,0,n-1,0,prev,-val);
         }
         st.update(0,0,n-1,0,r,val);
         int l = st.QueryFirstZero(0, 0, n - 1);
         if (l != -1) maxL = Math.max(maxL, r - l + 1);
         map.put(nums[r], r);
       }
       return maxL;
    }
}