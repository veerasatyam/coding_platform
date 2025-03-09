import java.util.Arrays;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low= 1, high = position[position.length-1]-position[0];
        int ans = 0; 
        
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canPlaceball(mid, m, position)) {   
                ans = mid; 
                low = mid + 1; 
            } else {
                high = mid - 1; 
            }
        }
        return ans;
    }
    public boolean canPlaceball(int x , int m , int[] position)
    {
        int balls=1,lastplaced=position[0];

        for(int i=1;i<position.length;i++)
        {
            if(position[i]-lastplaced>=x)
            {
                lastplaced=position[i];
                balls++;
            }
            if(balls>=m) return true;
        }
        return false;
    }
}