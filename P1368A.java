import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1368A {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }

        int t = s.nextInt();
        while(t-->0) {
            int a = s.nextInt();
            int b = s.nextInt();
            int n = s.nextInt();
            int count = 0;

            while (a <= n && b <= n) {
                if (a < b) {
                    a += b;
                } else {
                    b += a;
                }
                count++;
            }
            System.out.println(count);
        }
    }
}
