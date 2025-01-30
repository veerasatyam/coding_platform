// chatgpt code don't past it i will submit it later

import java.util.Scanner;

public class O {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine().trim();
        scanner.close();

        // Operators to check
        char[] operators = {'+', '-', '*', '/'};
        
        // Find the operator
        char operator = ' ';
        for (char op : operators) {
            if (expression.indexOf(op) != -1) {
                operator = op;
                break;
            }
        }

        // Extract numbers based on the operator
        int operatorIndex = expression.indexOf(operator);
        int A = Integer.parseInt(expression.substring(0, operatorIndex).trim());
        int B = Integer.parseInt(expression.substring(operatorIndex + 1).trim());

        // Compute and print the result
        int result = 0;
        switch (operator) {
            case '+':
                result = A + B;
                break;
            case '-':
                result = A - B;
                break;
            case '*':
                result = A * B;
                break;
            case '/':
                result = A / B;
                break;
        }

        System.out.println(result);
    }
}
