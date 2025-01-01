import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1881A {
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
            int m = s.nextInt();
            String x = s.next();
            String str = s.next();
            
            if (x.contains(str)) {
                System.out.println(0);
                continue;
            }

            int count = 0;
            StringBuilder current = new StringBuilder(x);
            
            while (current.length() <= 2 * 25) {
                current.append(current);
                count++;

                if (current.toString().contains(str)) {
                    System.out.println(count);
                    break;
                }
            }

            if (!current.toString().contains(str)) {
                System.out.println(-1);
            }
        }

        s.close();
    }
}
