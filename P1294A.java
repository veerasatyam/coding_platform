import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1294A {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        
        int t = s.nextInt();
        while (t-- > 0) {
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            int n = s.nextInt();
            
            int totalCoins = a + b + c + n;
            
            if (totalCoins % 3 != 0) {
                System.out.println("NO");
            } else {
                int target = totalCoins / 3;
                if (target >= a && target >= b && target >= c) {
                    int requiredCoins = (target - a) + (target - b) + (target - c);
                    if (requiredCoins <= n)  System.out.println("YES");
                     else System.out.println("NO");
                }    
                else System.out.println("NO");
            }
        }
        s.close();
    }
}
