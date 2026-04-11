//  brute force
class Solution {
    public List<Integer> grayCode(int n) {
        ArrayList<String> result = new ArrayList<>();
        result.add("0");
        result.add("1");
        if (n == 1) {
            List<Integer> res = new ArrayList<>();
            res.add(0);
            res.add(1);
            return res;
        }
        for (int i = 2; i <= n; i++) {
            int size = result.size();
            for (int j = size - 1; j >= 0; j--) {
                result.add(result.get(j));
            }
            for (int j = 0; j < size; j++) {
                result.set(j, "0" + result.get(j));
            }
            for (int j = size; j < 2 * size; j++) {
                result.set(j, "1" + result.get(j));
            }
        }
        List<Integer> res = new ArrayList<>();
        for (String x : result)res.add(Integer.parseInt(x, 2));
        return res;
    }
}

// optimal version
class Solution {
    public List<Integer> grayCode(int n) {
        int size = 1 << n;  
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }
}