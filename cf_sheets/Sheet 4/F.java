import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class F {
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
            String a = s.next();
            if(a.length()>10)  System.out.println(a.charAt(0) + "" + (a.length() - 2) + "" + a.charAt(a.length() - 1));
            else System.out.println(a);
        }
        s.close();
    }
}
