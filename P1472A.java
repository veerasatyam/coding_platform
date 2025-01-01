import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1472A {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        
        int t = s.nextInt();
        while (t-- > 0) {
            int w = s.nextInt();
            int h = s.nextInt();
            int n = s.nextInt();
            int no_pieces = 1;
            
            while (w % 2 == 0) {
                w /= 2;
                no_pieces *= 2;
            }
            
            while (h % 2 == 0) {
                h /= 2;
                no_pieces *= 2;
            }
            
            if (no_pieces >= n) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
        s.close();
    }
}
