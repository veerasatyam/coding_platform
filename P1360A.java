import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1360A {
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
            int S = Math.max(2*Math.min(a,b),Math.max(a,b));
            System.out.println(S*S);
        }
        s.close();
    }
}
