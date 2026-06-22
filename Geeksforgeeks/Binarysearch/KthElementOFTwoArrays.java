// brute force approach 

import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public int kthElement(int a[], int b[], int k) {
        int n = a.length;
        int m = b.length;
        int[] arr = new int[n + m];
        for(int i = 0;i < n;i++) arr[i] = a[i];
        for(int i = 0;i<m;i++) arr[i + n] = b[i];
        Arrays.sort(arr);
        return arr[k - 1];
    }
}


// using Priority Queue
class Solution {
    public int kthElement(int a[], int b[], int k) {
         PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : a) pq.add(i);
        for (int i : b) pq.add(i);
        while (k-- > 1) pq.poll();
        return pq.peek();
    }
}

// using merge sort logic
class Solution {
    public int kthElement(int a[], int b[], int k) {
        int n = a.length;
        int m = b.length;
        int x = 0;
        int i = 0;
        int j = 0;
        int last = -1;

        while(i < n && j < m){
            if(a[i] <= b[j]){
                last = a[i];
                i++;
            }else{
                last = b[j];
                j++;
            }

            x++;
            if(x == k) return last;
        }

        while(i < n){
            last = a[i];
            i++;
            x++;
            if(x == k) return last;
        }

        while(j < m){
            last = b[j];
            j++;
            x++;
            if(x == k) return last;
        }

        return last;
    }
}


class Solution {
    public int kthElement(int a[], int b[], int k) {
        int l = Math.min(findMin(a), findMin(b));
        int h = Math.max(findMax(a), findMax(b));
        int ans = -1;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            int c = count(a, mid) + count(b, mid);

            if (c >= k) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private int findMax(int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int x : arr) {
            max = Math.max(max, x);
        }
        return max;
    }

    private int findMin(int arr[]) {
        int min = Integer.MAX_VALUE;
        for (int x : arr) {
            min = Math.min(min, x);
        }
        return min;
    }

    private int count(int[] arr, int mid) {
        int count = 0;
        for (int num : arr) {
            if (num <= mid) count++;
        }
        return count;
    }
}
