import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      
        int N = scanner.nextInt();
        int even = 0,odd = 0,pos = 0,neg = 0;
        for (int i = 0; i < N; i++) {
            int number = scanner.nextInt();

            if (number % 2 == 0) {
                even++;
            } else {
                odd++;
            }

            if (number > 0) {
                pos++;
            } else if (number < 0) {
                neg++;
            }
        }

        
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
        System.out.println("Positive: " + pos);
        System.out.println("Negative: " + neg);

        scanner.close();
    }
}
