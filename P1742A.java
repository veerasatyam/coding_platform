import java.util.Scanner;

public class P1742A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            if (a + b == c || a + c == b || b + c == a) System.out.println("YES");
            else System.out.println("NO");
        }
        
        s.close();
    }
}
