import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class O {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        
        int n = s.nextInt();
        
        if (n == 1) {
            System.out.println("0");
        } else if (n == 2) {
            System.out.println("1");
        } else {
            int[] a = new int[n];
            a[0] = 0;
            a[1] = 1;
            for (int i = 2; i < n; i++) a[i] = a[i - 1] + a[i - 2];
            System.out.println(a[n - 1]);
        }
        s.close();
    }
}
