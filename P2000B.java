import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class P2000B {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }

        int t = s.nextInt();
        while(t-- > 0) {
            int n = s.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = s.nextInt();
            }

            HashSet<Integer> b = new HashSet<>();
            b.add(a[0]);
            boolean isValid = true;

            for(int i = 1; i < n; i++) {
                int v =Math.abs(a[i] - 1);
                int u =Math.abs(a[i]+1);
                if(b.contains(v) || b.contains(u)) {
                    b.add(a[i]);
                } else {
                    isValid = false;
                    break;
                }
            }

            if(isValid) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        s.close();
    }
}
