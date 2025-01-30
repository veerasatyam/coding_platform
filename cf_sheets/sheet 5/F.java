import java.util.Scanner;

public class F {
    long sum(int x, int y) {
        long sum = 0;
        for (int i = 2; i <= y; i += 2) {
            sum = sum + (long) Math.pow(x, i);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int X = s.nextInt();
        int N = s.nextInt();
        F obj = new F();
        long y = obj.sum(X, N);
        System.out.println(y);
    }
}
