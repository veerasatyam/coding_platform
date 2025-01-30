import java.util.Scanner;

public class B {
    public static void printNumbers(int n) {
        for (int i = 1; i <= n; i++) {
            if (i != 1) System.out.print(" ");
            System.out.print(i);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        printNumbers(n);
        s.close();
    }
}
