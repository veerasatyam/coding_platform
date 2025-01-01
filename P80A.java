import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P80A {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in); 
        }

        int n = s.nextInt(); 
        int m = s.nextInt(); 
        boolean foundNextPrime = false; 
        for (int i = n + 1; i <= m; i++) {
            if (isPrime(i)) {
                if (i == m) foundNextPrime = true;
                break;
            }
        }
        if (foundNextPrime)  System.out.println("YES");
        else  System.out.println("NO");

        s.close();
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false; 
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false; 
        }
        return true; 
    }
}
