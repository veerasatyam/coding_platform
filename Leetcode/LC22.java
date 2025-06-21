import java.util.ArrayList;
import java.util.List;

class Solution {
    ArrayList<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        generate(0, 0, "", ans, n);
        return ans;
    }

    void generate(int ob, int cb, String str, ArrayList<String> ans, int n) {
        if (str.length() == 2 * n) {
            ans.add(str);
            return;
        }
        if (ob < n) {
            generate(ob + 1, cb, str + "(", ans, n);
        }
        if (cb < ob) {
            generate(ob, cb + 1, str + ")", ans, n);
        }
    }
}
