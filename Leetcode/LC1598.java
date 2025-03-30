class Solution {
    public int minOperations(String[] logs) {
        int count = 0;
        for (String x : logs) {
            if (x.equals("../"))
            {
                if(count<=0)
                {
                    count=0;
                } 
                else
                {
                    count--;
                }
               
            } 
            else if (x.equals("./")) count = count;
            else count++;
        }
        return count;
    }
}


// using stacks 
// import java.util.Stack;

// class Solution {
//     public int minOperations(String[] logs) {
//         Stack<String> stack = new Stack<>();
        
//         for (String log : logs) {
//             if (log.equals("../")) {
//                 if (!stack.isEmpty()) {
//                     stack.pop();
//                 }
//             } else if (!log.equals("./")) {
//                 stack.push(log);
//             }
//         }
        
//         return stack.size();
//     }
// }

