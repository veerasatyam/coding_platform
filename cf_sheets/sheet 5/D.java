import java.util.Scanner;

public class D {

    public static boolean isPrime(int N) {
        if (N <= 1) {
            return false;
        }
        if (N == 2) {
            return true;
        }
        if (N % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= N; i += 2) {
            if (N % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        while(T-->0){
            int N = s.nextInt();
            if (isPrime(N)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        s.close();
    }
}
