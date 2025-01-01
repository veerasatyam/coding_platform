import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1729A {
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
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            int elev1 = Math.abs(a-1);
            int elev2 = Math.abs(b-c) + Math.abs(c-1);
            if(elev1 < elev2) System.out.println(1);
            else if(elev1 > elev2) System.out.println(2);
            else System.out.println(3);
        }
        s.close();
    }
}
