import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String S = s.nextLine();
        String T = s.nextLine();
        System.out.println(S.length() + " " + T.length());
        System.out.println(S + " " + T);
        s.close();
    }
}
