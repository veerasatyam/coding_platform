import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P472A {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
       
        int n = s.nextInt();
        if (n % 2 == 0) System.out.println(4 + " " + (n - 4));
         else System.out.println(9 + " " + (n - 9));
        s.close();
    }
}
