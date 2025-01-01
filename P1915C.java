import java.util.Scanner;

public class P1915C {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        
        while (t-- > 0) {
            int n = s.nextInt();
            long sum = 0;
            for (int i = 0; i < n; i++) sum += s.nextLong();
            long x = (long) Math.sqrt(sum);
            if (x * x == sum)   System.out.println("YES");
            else  System.out.println("NO");
        }

        s.close();
    }
}
