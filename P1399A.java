import java.util.Arrays;
import java.util.Scanner;

public class P1399A {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int T = s.nextInt();
        while (T-- > 0) {
            int n = s.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = s.nextInt();
            Arrays.sort(a);
            boolean b = true;
            for (int i = 1; i < n; i++) {
                if(a[i] - a[i-1] > 1){
                    b = false;
                    break;
                }
            }
            if (b)  System.out.println("YES");
            else System.out.println("NO");
        }
        
        s.close();
    }
}
