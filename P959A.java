import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class P959A {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int n = s.nextInt();
        if (n % 2 == 0) System.out.println("Mahmoud");
        else  System.out.println("Ehab");
        s.close();
    }
}
