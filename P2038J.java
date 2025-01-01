import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P2038J {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int n = s.nextInt();
        int people = 0;
        while (n-- > 0) {
            char x = s.next().charAt(0);
            int y = s.nextInt();
            if (x == 'P') {
                people += y;
            } else {
                if (people < y) {
                    if (y - people > 0) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                    people = 0;
                } else {
                    people -= y;
                    System.out.println("NO");
                }
            }
        }
        s.close();
    }
}
