class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        int[] startTime = new int[n];
        for(String log : logs){
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            String type = parts[1];
            int time = Integer.parseInt(parts[2]);
            if(type.equals("start")){
               if(!stack.isEmpty()){
                   int prevId = stack.pop();
                   result[prevId] += time - startTime[prevId];
                   startTime[prevId] = -1;
               }else
               stack.push(id);
               startTime[id] = time;
            }else{
              int prevId = stack.pop();
              result[prevId] += time - startTime[prevId] + 1;
            }
        }
        return result;
    }
}