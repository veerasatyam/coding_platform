import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1369A {
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
            if (n % 4 == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        s.close();
    }
}
