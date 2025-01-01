import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1971A {
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
            int x= s.nextInt();
            int y=s.nextInt();
            System.out.println(Math.min(x, y)+" "+Math.max(x, y));
        }
        s.close();
    }
}
