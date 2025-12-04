// stack appraoch
class Solution {
    public int countCollisions(String directions) {
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (char c : directions.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (c == 'R') {
                stack.push('R');
            } else if (c == 'S') {
                while (!stack.isEmpty() && stack.peek() == 'R') {
                    stack.pop();
                    count++;
                }
                stack.push('S');
            } else { 
                if (stack.peek() == 'R') {
                    stack.pop();
                    count += 2;
                    while (!stack.isEmpty() && stack.peek() == 'R') {
                        stack.pop();
                        count++;
                    }
                    stack.push('S');
                } else if (stack.peek() == 'S') {
                    count++;
                    stack.push('S');
                } else {
                    stack.push('L');
                }
            }
        }
        return count;
    }
}


// optimal solution 

class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int i = 0;
        int j = n - 1;
        while (i<n && directions.charAt(i)=='L') i++;
        while (j>=0 && directions.charAt(j)=='R') j--;
        int collisions = 0;
        for (int k = i; k <= j; k++)if(directions.charAt(k) != 'S') collisions++;
        return collisions;
    }
}
