import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1186A {
    public static void main(String[] args) {
        Scanner s = null;
         try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int n = s.nextInt();
        int m = s.nextInt();
        int k = s.nextInt();
        if(Math.min(m, k) >= n) System.out.println("Yes");
        else System.out.println("No");
        s.close();
    }
}
