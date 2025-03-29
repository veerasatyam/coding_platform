class Solution 
{ 
    static long ValidPair(int a[], int n) 
	{ 
        Arrays.sort(a);
        int left = 0;
        int right = n - 1;
        int count = 0;

        while (left < right) {
            if (a[left] + a[right] > 0) {
                count += (right - left);
                right--;
            } else {
                left++;
            }
        }

        return count;
	}
} 