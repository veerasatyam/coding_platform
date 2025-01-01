import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1385B {
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
            boolean[] b = new boolean[n + 1];
            
            for (int i = 0; i < 2 * n; i++) a[i] = s.nextInt();
            
            for (int i = 0; i < 2 * n; i++) {
                int x = a[i];
                if (!b[x]) {
                    System.out.print(x + " ");
                    b[x] = true;
                }
            }
            System.out.println();
        }
        
        s.close();
    }
}
