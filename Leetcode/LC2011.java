class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int add = 0, sub = 0;
        for (String a : operations) {
            if (a.equals("X--") || a.equals("--X"))
                sub++;
            else
                add++;
        }
        return add - sub;
    }
}
