import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner  s= null;
        try {
           s = new Scanner(new File("input.txt")); 
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        long A = s.nextLong();
        long B = s.nextLong();
        long Q = s.nextLong();
        
        if (Q % 3 == 1) {
            System.out.println(A);
        } else if (Q % 3 == 2) {
            System.out.println(B);
        } else {
            System.out.println(A ^ B);
        }
        
        s.close();
    }
}
