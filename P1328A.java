import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1328A {
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
            int opr_count = (a % b == 0) ? 0 : b - (a % b);
            System.out.println(opr_count);
        }
        s.close();
    }
}
