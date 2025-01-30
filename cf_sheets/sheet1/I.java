import java.util.Scanner;

public class I {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int A = s.nextInt();
        int B = s.nextInt();
        if (A >= B) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        s.close();
    }
}
