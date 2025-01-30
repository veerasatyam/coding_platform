import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        boolean foundEven = false;
        for (int i = 2; i <= N; i += 2) {
            System.out.println(i);
            foundEven = true;
        }
        if (!foundEven) {
            System.out.println("-1");
        }
        scanner.close();
    }
}
