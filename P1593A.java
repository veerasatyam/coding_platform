
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class P1593A {
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
            int A = Math.max(0, Math.max(b, c) - a + 1);
            int B = Math.max(0, Math.max(a, c) - b + 1);
            int C = Math.max(0, Math.max(a, b) - c + 1);
            System.out.println(A + " " + B + " " + C);
        }
        s.close();
   }
}
