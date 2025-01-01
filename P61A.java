import java.util.Scanner;

public class P61A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String A = s.next();
        String B = s.next();
        String result = "";
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == B.charAt(i)) result += "0";
                 else result += "1";
        }
        System.out.println(result);
        s.close();
    }
}
