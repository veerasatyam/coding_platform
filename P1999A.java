import java.util.Scanner;
//submitted
public class P1999A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            int sum = (n / 10) + (n % 10);  
            System.out.println(sum);
        }

        s.close();
    }
}
