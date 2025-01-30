import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        final int OPassword = 1999;

        while (true) {
            int password = s.nextInt();

            if (password == OPassword) {
                System.out.println("Correct");
                break; 
            } else {
                System.out.println("Wrong");
            }
        }

        s.close();
    }
}
