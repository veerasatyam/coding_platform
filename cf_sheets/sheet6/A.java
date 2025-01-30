import java.util.Scanner;

public class A {
    public static String isPowerOfTwo(long N) {
        if (N > 0 && (N & (N - 1)) == 0) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        System.out.println(isPowerOfTwo(N));
    }
}
