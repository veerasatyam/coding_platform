import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1837A {
    public static void main(String args[]){
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int t = s.nextInt();
        while(t-->0)
        {
            int x = s.nextInt();
            int k = s.nextInt();
            if (x % k != 0) {
                System.out.println(1);
                System.out.println(x);
            } else {
                System.out.println(2);
                System.out.println(x - 1 + " " + 1);
            }
        }
        s.close();
    }
}
