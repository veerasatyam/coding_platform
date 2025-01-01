import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1873D {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        
        int t = s.nextInt();
        while(t-- > 0) {
            int n = s.nextInt();
            int k = s.nextInt();
            String str = s.next();
            
            int operations = 0;
            int i = 0;
            
            while (i < n) {
                if (str.charAt(i) == 'B') {
                    operations++;
                    i += k;
                } else {
                    i++;
                }
            }
            
            System.out.println(operations);
        }
        
        s.close();
    }
}
