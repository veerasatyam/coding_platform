class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, ArrayList<Integer>> rows = new HashMap<>();
        Map<Integer, ArrayList<Integer>> column = new HashMap<>();

        for(int[] b : buildings){
            int x = b[0],y=b[1];
            rows.computeIfAbsent(x,k->new ArrayList<>()).add(y);            
            column.computeIfAbsent(y,k->new ArrayList<>()).add(x);            
        }
        for(List<Integer> ls : rows.values()) Collections.sort(ls);
        for(List<Integer> ls : column.values()) Collections.sort(ls);
        int res = 0;
        for(int[] b : buildings){
            int x = b[0],y=b[1];
            List<Integer> ys = rows.get(x);
            List<Integer> xs = column.get(y);
            if (ys==null||xs==null)continue;
            int yPos = binarySearch(ys, y);
            int xPos = binarySearch(xs, x);
            if (yPos==-1||xPos==-1)continue;
            boolean hasLeft = yPos>0;
            boolean hasRight = yPos<ys.size()-1;
            boolean hasAbove = xPos>0;
            boolean hasBelow = xPos<xs.size()-1;
            if (hasLeft && hasRight && hasAbove && hasBelow) res++;
        }
        return res;
    }
    private int binarySearch(List<Integer> list, int target) {
    int left=0,right=list.size()-1;
    while (left<=right) {
        int mid = (right+left)/2;
        int val = list.get(mid);
        if (val==target) {
            return mid;  
        }else if(val<target) {
            left=mid+1;
        }else{
            right = mid - 1;
        }
    }
    return -1;
   }
}