import java.util.Scanner;

public class W {
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        int N=s.nextInt();
        int i,m,j;
        for (i = 0; i < N; i++) {
            for (j = 0; j < N - i - 1; j++) System.out.print(" ");
            for (m = 0; m < (2 * i + 1); m++) System.out.print("*");
            System.out.println();
        }
        for (i = N - 1; i >= 0; i--) {
            for (j = 0; j < N - i - 1; j++) System.out.print(" ");
            for (m = 0; m < (2 * i + 1); m++)  System.out.print("*");
            System.out.println(); 
        }
        s.close();
    }
}
