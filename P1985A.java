import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1985A {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        
        int t = s.nextInt();
        while (t-- > 0) {
            String a = s.next();
            String b = s.next();
            char temp = a.charAt(0);
            a = b.charAt(0) + a.substring(1);
            b = temp + b.substring(1);
            System.out.println(a + " " + b);
        }
        s.close();
    }
}
