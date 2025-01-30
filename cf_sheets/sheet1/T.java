import java.util.Scanner;

public class T {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long A = s.nextInt();
        long B = s.nextInt();
        long C = s.nextInt();
        long[] numbers = {A, B, C};
        java.util.Arrays.sort(numbers);
        for (long num : numbers)
         {
            System.out.println(num);
        }
        System.out.println();
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        s.close();
    }
}
