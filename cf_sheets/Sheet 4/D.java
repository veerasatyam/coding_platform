import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        String a = s.next();
        String b = s.next();
        System.out.println(a.length()+" "+b.length());
        System.out.println(a+b);
        char temp = b.charAt(0);
        char temp1 =a.charAt(0);
        System.out.println((temp+a.substring(1))+" "+(temp1+b.substring(1)));
    }
}
