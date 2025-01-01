import java.util.Scanner;

public class P469A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int p = s.nextInt();
        int[] xLevels = new int[p];
        for (int i = 0; i < p; i++)  xLevels[i] = s.nextInt();
        int q = s.nextInt();
        int[] yLevels = new int[q];
        for (int i = 0; i < q; i++) yLevels[i] = s.nextInt();
        boolean[] pass = new boolean[N];
        for (int i = 0; i < p; i++)  pass[xLevels[i] - 1] = true;
        for (int i = 0; i < q; i++) pass[yLevels[i] - 1] = true;
        for (int i = 0; i < N; i++) {
            if (!pass[i]) {
                System.out.println("Oh, my keyboard!");
                return;
            }
        }
        System.out.println("I become the guy.");
        s.close();
    }
}
