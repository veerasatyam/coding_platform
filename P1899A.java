import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1899A {
   public static void main(String[] args) {
       Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }

        int t = s.nextInt();
        while(t-->0)
        {
            int n = s.nextInt();
            if (n % 3 == 0) System.out.println("Second");
            else System.out.println("First");
        }
        s.close();
   } 
}
