import java.util.Scanner;

public class J {
    public static void main(String[] args) {
       
        Scanner s = new Scanner(System.in);
        int A = s.nextInt();
        int B = s.nextInt();
        if (A % B == 0 || B % A == 0) {
            System.out.println("Multiples");
        } else {
            System.out.println("No Multiples");
        }
        s.close();
    }
}
