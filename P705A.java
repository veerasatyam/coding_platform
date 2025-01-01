import java.util.Scanner;

public class P705A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String Str_love = "I love";
        String Str_hate = "I hate";
        String str_complete = "";

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                str_complete += Str_hate;
            } else {
                str_complete += Str_love; 
            }
            if (i < n) {
                str_complete += " that ";
            } else {
                str_complete += " it";
            }
        }
        System.out.println(str_complete);
        s.close();
    }
}
