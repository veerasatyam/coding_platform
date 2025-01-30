import java.util.Scanner;

public class E {
    public void swapN(int X, int Y) {
        System.out.println(Y + " " + X);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int y = s.nextInt();
        E e = new E();
        e.swapN(x, y);
        s.close();
    }
}
