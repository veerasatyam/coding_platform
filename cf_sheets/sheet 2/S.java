import java.util.Scanner;

public class S {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
           int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            int X = s.nextInt();
            int Y = s.nextInt();
            int sum = 0;
            for (int j = Math.min(X, Y) + 1; j <= Math.max(X, Y) - 1; j++) {
                if (j % 2 != 0) {
                    sum += j;
                }
            }
            System.out.println(sum);
        }
        
        s.close();
    }
}
