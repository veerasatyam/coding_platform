import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1542A {
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
            int[] a = new int[2 * n];
            int even = 0, odd = 0;
            for (int i = 0; i < 2 * n; i++) {
                a[i] = s.nextInt();
                if (a[i] % 2 == 0) even++;
                else  odd++;
            }
            if (even == n && odd == n) System.out.println("Yes");
            else System.out.println("No");
        }

        s.close();
    }
}
