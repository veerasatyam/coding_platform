class Solution {
    public List<String> buildArray(int[] target, int n) {
         Stack<Integer> stack = new Stack<>();
         List<String> ans = new ArrayList<>();
            int j = 0;
         for(int i = 1;i<=n;i++){
                stack.push(i);
                ans.add("Push");
                if(stack.peek()==target[j] && j<target.length){
                    j++;
                }else{
                    stack.pop();
                    ans.add("Pop");
                }
                if(j==target.length){
                    break;
                }
         }
         return ans;
    }
}

// same code and better readability
class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int index = 0;
        for (int num = 1; num <= n && index < target.length; num++) {
            result.add("Push");
            if (num == target[index]) {
                index++;
            } else {
                result.add("Pop");
            }
        }
        return result;
    }
}