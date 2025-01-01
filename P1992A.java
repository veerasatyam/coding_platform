import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1992A {
    public static int maxBananaProduct(int a, int b, int c) {
        for (int i = 0; i < 5; i++) {
            if (a <= b && a <= c) {
                a++;
            } else if (b <= a && b <= c) {
                b++;
            } else {
                c++;
            }
        }
        return a * b * c;
    }
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
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            int result = maxBananaProduct(a, b, c);
            System.out.println(result);
        }
    }
}
