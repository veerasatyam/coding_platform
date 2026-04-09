class Solution {
    ArrayList<Integer> intersection(int[] a, int[] b) {
        HashSet<Integer> set = new HashSet<>();
        for(int x : a) set.add(x);
        ArrayList<Integer> res = new ArrayList<>();
        for(int x : b){
            if(set.contains(x)){
                res.add(x);
                set.remove(x);
            }
        } 
        return res;
    }
}


// better approach
class Solution {
    ArrayList<Integer> intersection(int[] a, int[] b) {
        // code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        int m = a.Length;
        int n = b.Length;
        int i = 0, j = 0;
        while (i < m && j < n){
            if (i > 0 && a[i - 1] == a[i])
            {
                i++;
                continue;
            }
            if (a[i] < b[j]) i++;
            else if (a[i] > b[j])j++;
            else
            {
                res.Add(a[i]);
                i++;
                j++;
            }
        }
        return res;
    }
}