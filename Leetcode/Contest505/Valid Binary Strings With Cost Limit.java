class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateValidStrings(int n, int k) {
        helper(n,k,0,0,0,new StringBuilder());
        return result;
    }
    private void helper(int n,int k,int cost,int prevOnes,int index,StringBuilder str){
        if(index == n){
            if(cost <= k){
                result.add(str.toString());
            }
            return;
        }
        // add 0
        str.append("0");
        helper(n,k,cost,0,index+1,str);
        str.deleteCharAt(str.length() - 1);
        // add 1
        if(prevOnes == 0){
            str.append("1");
            cost = cost + index;
            helper(n,k,cost,1,index+1,str);
            str.deleteCharAt(str.length() - 1);
        }
    }
}