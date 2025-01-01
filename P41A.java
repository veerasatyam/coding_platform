import java.util.Scanner;
//submitted
public class P41A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String S = s.nextLine();
        String T = s.nextLine();
        
        String SR = "";
        int length = S.length();
        for (int i = 0; i < length; i++) {
            SR += S.charAt(length - 1 - i);
        }
        if (SR.equals(T)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        
        s.close(); 
    }
}
