import java.util.Scanner;

public class P686A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int x = s.nextInt();
        int distress = 0;

        while (n-- > 0) {
            char a = s.next().charAt(0);
            int b = s.nextInt();
            
            if (a == '+') {
                x += b;
            } else {
                if (x < b) {
                    distress++;
                } else {
                    x -= b;
                }
            }
        }
        
        System.out.println(x + " " + distress);
        
        s.close();
    }
}
