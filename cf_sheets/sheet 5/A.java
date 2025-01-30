import java.util.Scanner;

public class A {

    public static int sum(int x, int y) {
        return x + y;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int y = s.nextInt();
        int result = sum(x, y);
        System.out.println(result);
        s.close();
    }
}
