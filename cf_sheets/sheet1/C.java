import java.util.Scanner;
public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int X = scanner.nextInt();
        int Y = scanner.nextInt();
        System.out.println(X+ " + "+Y+ " = "+(X+Y));
        System.out.println(X+ " * "+Y+ " = "+(long)(X*Y));
        System.out.println(X+ " - "+Y+ " = "+(X-Y));
        

        scanner.close();
    }
}