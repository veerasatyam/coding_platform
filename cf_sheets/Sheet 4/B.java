import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String S = s.nextLine();
        int index = S.indexOf('\\');
        System.out.println(S.substring(0, index));
        s.close();
    }
}
