import java.util.Scanner;

public class Q {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int L = s.nextInt();
        int R = s.nextInt();
        int M = s.nextInt();
        
        long product = 1;
        for (int i = L; i <= R; i++) {
            product = (product * i) % M;
        }
        
        System.out.println(product);
        s.close();
    }
}
