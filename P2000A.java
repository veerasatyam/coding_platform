import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P2000A {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        
        int t = s.nextInt();
        while (t-- > 0) {
            String str = s.next();
            if (str.length() > 3) {
                if (str.startsWith("10") && str.charAt(2) != '0') {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                if ((str.length() == 3 && str.startsWith("10")) && (str.charAt(2) != '0' && str.charAt(2) != '1')) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
        s.close();
    }
}
