import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P151A {

    int findMin(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int n = s.nextInt(); 
        int k = s.nextInt();
        int l = s.nextInt(); 
        int c = s.nextInt(); 
        int d = s.nextInt();
        int p = s.nextInt();
        int nl = s.nextInt(); 
        int np = s.nextInt(); 
        int totalMlOfDrink = k * l; 
        int toastsCanMake = totalMlOfDrink / nl;
        int limes = c * d;
        int salt = p / np;
        P151A cal = new P151A();
        System.out.println(cal.findMin(toastsCanMake / n, limes / n, salt / n));
        s.close();

    }
}
