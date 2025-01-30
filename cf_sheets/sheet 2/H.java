import java.util.Scanner;

public class H {

    public static String isPrime(int X) {
        if (X <= 1) {
            return "NO";
        }
        if (X <= 3) {
            return "YES";
        }
        if (X % 2 == 0 || X % 3 == 0 || X % 5 == 0 || X % 7 == 0 || X % 11 == 0) 
        {
            return "NO";
        }
        
        return "YES";
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int X = s.nextInt();
        System.out.println(isPrime(X));
        s.close();
    }
}
