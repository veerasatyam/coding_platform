class Solution {
    public void mergeArrays(int a[], int b[]) {
        int i=a.length-1,j=0;
         while (i >= 0 && j < b.length) {
            if (a[i] < b[j])
                i--;
            else {
                int temp = b[j];
                b[j] = a[i];
                a[i] = temp;
                i--;
                j++;
            }
        }
        Arrays.sort(a);
        Arrays.sort(b); 
    }
}
