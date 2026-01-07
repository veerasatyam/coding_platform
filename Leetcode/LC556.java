// refer the problem next premutation it is quite similar to that...


class Solution {
    public int nextGreaterElement(int n) {
        String str = String.valueOf(n);
        int len = str.length();
        int i = len - 2;
        while (i >= 0 && str.charAt(i) >= str.charAt(i + 1)) i--;
        if (i < 0) return -1;
        int j = len - 1;
        while (j > i && str.charAt(j) <= str.charAt(i)) j--;
        String swapped = swap(str, i, j);
        StringBuilder sb = new StringBuilder();
        sb.append(swapped.substring(0,i + 1));
        sb.append(new StringBuilder(swapped.substring(i + 1)).reverse());
        long ans = Long.parseLong(sb.toString());
        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
    }

    private String swap(String str, int i, int j) {
        char[] arr = str.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }
}
