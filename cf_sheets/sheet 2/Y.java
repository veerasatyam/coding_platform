import java.util.Scanner;

public class Y {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] fbseries = new int[N];
        if (N >= 1) fbseries[0] = 0;
        if (N >= 2) fbseries[1] = 1;
        for (int i = 2; i < N; i++)  fbseries[i] = fbseries[i - 1] + fbseries[i - 2];
        for (int i = 0; i < N; i++) {
            System.out.print(fbseries[i]);
            if (i < N - 1) {
                System.out.print(" ");
            }
        }
        System.out.println(); 
        s.close();
    }
}
