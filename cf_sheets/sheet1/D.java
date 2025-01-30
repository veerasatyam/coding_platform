import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        long A = scanner.nextLong();
        long B = scanner.nextLong();
        long C = scanner.nextLong();
        long D = scanner.nextLong();
        long result = (A * B) - (C * D);
        System.out.println("Difference = " + result);
        scanner.close();
    }
}

