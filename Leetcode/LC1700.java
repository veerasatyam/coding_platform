import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentQueue = new LinkedList<>();
        Stack<Integer> sandwichStack = new Stack<>();

        for (int student : students) {
            studentQueue.add(student);
        }

        for (int i = sandwiches.length - 1; i >= 0; i--) {
            sandwichStack.push(sandwiches[i]);
        }

        int unableToServe = 0;
        while (!studentQueue.isEmpty()) {
            if (sandwichStack.isEmpty()) {
                break;
            }
            if (studentQueue.peek() == sandwichStack.peek()) {
                studentQueue.poll();
                sandwichStack.pop();
                unableToServe = 0;
            } else {
                studentQueue.add(studentQueue.poll());
                unableToServe++;
                if (unableToServe == studentQueue.size()) {
                    break;
                }
            }
        }

        return studentQueue.size();
    }
}