import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1858A {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }

        int t = s.nextInt();
        while (t-- > 0) {
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            
            if (a >= b) {
                a = a + c / 2 + (c % 2);
                b = b + c / 2;
            } else {
                a = a + c / 2;
                b = b + c / 2 + (c % 2);
            }
            
            if (a > b) {
                System.out.println("First");
            } else {
                System.out.println("Second");
            }
        }
        s.close();
    }
}
