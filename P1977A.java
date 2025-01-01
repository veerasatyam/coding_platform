import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1977A {
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
            int n = s.nextInt();
            int m = s.nextInt();
            
            if (m >= 0 && m <= n && (n - m) % 2 == 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        s.close();
    }
}
