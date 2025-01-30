import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class I {
    public static void main(String[] args) {
         Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        String a = s.next();
        StringBuilder sb = new StringBuilder(a);
        sb.reverse();
        String reversedString = sb.toString();
        if(a.equals(reversedString)) System.out.println("YES");
        else System.out.println("NO");
        s.close();
    }
}
