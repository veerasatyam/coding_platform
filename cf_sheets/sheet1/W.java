import java.util.Scanner;

public class W {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String expression = s.nextLine();
        String[] parts = expression.split(" ");

        
        int A = Integer.parseInt(parts[0]);
        char operator = parts[1].charAt(0);
        int B = Integer.parseInt(parts[2]);
        int C = Integer.parseInt(parts[4]); 

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
            default:
                System.out.println("Invalid operator.");
                s.close();
                return;
        }
        if (result == C) {
            System.out.println("Yes");
        } else {
            System.out.println(result);
        }

        s.close();
    }
}
