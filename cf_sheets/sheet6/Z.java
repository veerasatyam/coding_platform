import java.util.Scanner;

public class Z {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int R = s.nextInt();
        int S = s.nextInt();
        if (S * S <= 2 * R * R) {
            System.out.println("Circle");
        }
        else if (2 * R <= S) {
            System.out.println("Square");
        }
        else {
            System.out.println("Complex");
        }
        s.close();
    }
}
