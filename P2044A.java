import java.util.Scanner;

public class P2044A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            System.out.println(n - 1);
        }
        
        s.close();
    }
}
