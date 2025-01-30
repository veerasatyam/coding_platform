import java.util.Scanner;

public class G {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        
        for (int i = 0; i < T; i++) {
            int N = s.nextInt();
            System.out.println(factorial(N));
        }
        
        s.close(); 
    }

    public static long factorial(int n) {
        if (n == 0) {
            return 1; 
        }
        
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        
        return result;
    }
}
