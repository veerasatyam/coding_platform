import java.util.Scanner;
public class P71A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 1; i <= n; i++) {
            String word = s.next();
            if(word.length() <= 10) System.out.println(word);
            else System.out.println(word.charAt(0)+""+(word.length()-2)+""+word.charAt(word.length()-1));
        }
        s.close();
    }
}
