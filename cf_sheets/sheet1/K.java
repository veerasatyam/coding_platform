import java.util.Scanner;
public class K {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int A = s.nextInt();
        int B = s.nextInt();
        int C = s.nextInt();
        int min, max;
        if (A <= B && A <= C) {
            min = A;
        } else if (B <= A && B <= C) {
            min = B;
        } else {
            min = C;
        }
        if (A >= B && A >= C) {
            max = A;
        } else if (B >= A && B >= C) {
            max = B;
        } else {
            max = C;
        }
        System.out.println(min + " " + max);
        s.close();
    }
}
