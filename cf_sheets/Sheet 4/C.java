import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String X = s.next();
        String Y = s.next();
        if (X.compareTo(Y) < 0) System.out.println(X);
         else System.out.println(Y);
        s.close();
    }
}
