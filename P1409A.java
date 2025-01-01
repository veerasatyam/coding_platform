import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1409A {
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
            int diff = Math.abs(a - b);
            int count = diff / 10;
            if(diff %10 !=0) count++;
            System.out.println(count);
        }
        s.close();
    }
}
