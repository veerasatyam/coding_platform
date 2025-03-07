/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

      public class LC278 extends VersionControl {
        public int firstBadVersion(int n) {
          int l = 1, h = n;
          int ans = -1;
          
          while (l <= h) {
              int mid = l + (h - l) / 2;
              
              if (isBadVersion(mid)) {
                  ans = mid;
                  h = mid - 1;
              } else {
                  l = mid + 1;
              }
          }
            return ans;
        }
    }