import java.util.Scanner;

public class P996A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        int[] d = {100, 20, 10, 5, 1};
        int count = 0; 
        for (int i = 0; i < 5; i++) {
            if (n == 0) break; 
            count += (n / d[i]); 
            n %= d[i]; 
        }
        System.out.println(count);
        s.close();
    }
}
