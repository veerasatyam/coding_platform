import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class W {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int N = s.nextInt();
        int M = s.nextInt();
        int[][] a = new int[N][M];

       
        for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) a[i][j] = s.nextInt();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                int temp = a[i][j];
                a[i][j] = a[i][M - j - 1];
                a[i][M - j - 1] = temp;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
       s.close();
    }
}
