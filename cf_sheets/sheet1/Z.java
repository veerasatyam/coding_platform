import java.util.Scanner;

public class Z {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        long A = s.nextLong();
        long B = s.nextLong();
        long C = s.nextLong();
        long D = s.nextLong();
        double logA = Math.log(A);
        double logC = Math.log(C);
        if (B * logA > D * logC) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        
        s.close();
    }
}
