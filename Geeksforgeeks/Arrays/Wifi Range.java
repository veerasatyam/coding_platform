class Solution {
    public boolean wifiRange(String s, int x) {
        int n = s.length();
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int last = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                last = i;
            }
            prefix[i] = last;
        }
        last = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                last = i;
            }
            suffix[i] = last;
        }
        for (int i = 0; i < n; i++) {
            boolean leftCovered = (prefix[i] != -1) && (i - prefix[i] <= x);
            boolean rightCovered = (suffix[i] != -1) && (suffix[i] - i <= x);
            
            if (!leftCovered && !rightCovered) {
                return false;
            }
        }
        
        return true;
    }
}



// optimal solution // dry run on paper for better understanding
class Solution {
    public boolean wifiRange(String s, int x) {
        int n = s.length();
        
        // Tracks the rightmost room index that is completely covered by a WiFi router.
        // Initialized to -1 because no rooms are covered before we start scanning.
        int maxCovered = -1;

        for (int i = 0; i < n; i++) {
            // When a WiFi router is found at the current room index 'i'
            if (s.charAt(i) == '1') {
                
                // The leftmost reach of this current router is (i - x).
                // The next room that urgently needs coverage is (maxCovered + 1).
                // If the router's left reach cannot even touch or overlap with the 
                // next uncovered room, a permanent uncovered gap exists.
                if (i - x > maxCovered + 1) {
                    return false;
                }
                
                // If it successfully bridges the gap, update our coverage boundary.
                // The current router extends coverage up to index (i + x).
                // Math.max handles cases where a previous router's reach already exceeded this one.
                maxCovered = Math.max(maxCovered, i + x);
            }
        }

        // After checking all routers, ensure the final coverage reach 
        // spans at least to the last room in the hostel (index n - 1).
        return maxCovered >= n - 1;
    }
}