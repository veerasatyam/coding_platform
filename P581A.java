import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P581A {
     public static void main(String args[])
     {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }

        int a=s.nextInt();
        int b=s.nextInt();
        int k = Math.min(a, b);
        int d = (Math.max(a, b)-k)/2;
        System.out.println(k+" "+d);
        s.close();
     } 
}
