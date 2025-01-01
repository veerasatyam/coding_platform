import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1772 {
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
            String exp = s.next();
            System.out.println(Integer.parseInt(String.valueOf(exp.charAt(0)))+Integer.parseInt(String.valueOf(exp.charAt(2))));
        }
        s.close();
    }
}
