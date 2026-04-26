class Solution {
    public ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        int in = a.length, jn = b.length, kn = c.length;
        while (i < in && j < jn && k < kn) {
            while (i < in - 1 && a[i] == a[i + 1]) i++;
            while (j < jn - 1 && b[j] == b[j + 1]) j++;
            while (k < kn - 1 && c[k] == c[k + 1]) k++;
            if (a[i] == b[j] && b[j] == c[k]) {
                result.add(a[i]);
                i++; j++; k++;
            } 
            else if (a[i] < b[j]) {
                i++;
            } 
            else if (b[j] < c[k]) {
                j++;
            } 
            else {
                k++;
            }
        }
        return result;
    }
}