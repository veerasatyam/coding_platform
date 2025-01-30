import java.util.Scanner;

public class R {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (true) {
            int N = s.nextInt();
            int M = s.nextInt();
            if (N <= 0 || M <= 0) {
                break;
            }
            int sum = 0;
            for (int i = Math.min(N, M); i <= Math.max(N, M); i++) {
                sum += i; 
                System.out.print(i + " ");
            }

            System.out.println(" sum =" + sum);
        }
        
        s.close();
    }
}
