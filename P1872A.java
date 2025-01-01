import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1872A {

    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }

        int t = s.nextInt();
        
        while (t-- > 0) {
            int a = s.nextInt(); 
            int b = s.nextInt(); 
            int c = s.nextInt(); 
            int diff = Math.abs(a - b);

            if (diff == 0) {
                System.out.println(0);
            } else {
                int count = diff / c;

                if (diff % c != 0) count++;
                System.out.println((int)Math.ceil((double)count/2));
            }
        }


        s.close();
    }
}
