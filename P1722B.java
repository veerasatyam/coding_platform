import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1722B {
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
            String s1 = s.next();
            String s2 = s.next();
            s1 = s1.replace('B', 'G');
            s2 = s2.replace('B', 'G');
            if (s1.equals(s2)) System.out.println("YES");
            else System.out.println("NO");
        }

        s.close();
    }
}
