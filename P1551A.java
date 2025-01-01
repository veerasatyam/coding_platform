import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
// don't know the mistake 
public class P1551A {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }

        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            int c2 = n / 3;
            int c1 = n - 2 * c2;
            if (c1 + 2 * c2 != n) {
                c2++;
                c1 = n - 2 * c2;
            }
            System.out.println(c1 + " " + c2);
        }
        s.close();
    }
}
