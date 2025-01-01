import java.util.Scanner;

public class P1296A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int t = s.nextInt();
        
        while (t-- > 0) {
            int n = s.nextInt();
            int[] a = new int[n];
            boolean odd = false;
            boolean even = false;
            
            for (int i = 0; i < n; i++) {
                a[i] = s.nextInt();
                if (a[i] % 2 == 0) even = true;
                 else odd = true; 
            }
            
            if (odd && even) {
                System.out.println("YES");
            } else {
                int oddCount = 0;
                for (int i = 0; i < n; i++) {
                    if (a[i] % 2 != 0) {
                        oddCount++;
                    }
                }
                if (oddCount % 2 == 1) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
        
        s.close();
    }
}
