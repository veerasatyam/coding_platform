import java.util.Scanner;

public class U {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int A = s.nextInt();
        int B = s.nextInt();
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            int sum_digit = 0;
            int number = i; 
            while (number != 0) {
                int remainder = number % 10;
                sum_digit += remainder;
                number /= 10;
            }
            if (sum_digit >= A && sum_digit <= B)  sum += i;
        }

        System.out.println(sum);
    }
}
