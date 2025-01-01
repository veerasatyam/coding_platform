import java.util.Scanner;
//submitted
public class P977A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        int k = s.nextInt();
        
        
        for (int i = 0; i < k; i++) {
            if (n % 10 == 0) {
                n /= 10; 
            } else {
                n--; 
            }
        }
        System.out.println(n);
        s.close();
    }
}
