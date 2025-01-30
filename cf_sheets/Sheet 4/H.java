import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class H {
    public static void main(String[] args) {
         Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int t=s.nextInt();
        while(t-->0)
        {
            String a = s.next();
            if(a.contains("101") || a.contains("010")) System.out.println("Good");
            else System.out.println("Bad");
        }
        s.close();
    }
}
