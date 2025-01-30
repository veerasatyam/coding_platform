import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class I {
    
    public static int[][] swap(int[][] a, int x, int y) {
        for (int i = 0; i < a.length; i++) {
            int temp = a[x][i];
            a[x][i] = a[y][i];
            a[y][i] = temp;
        }
        for (int i = 0; i < a.length; i++) {
            int temp = a[i][x];
            a[i][x] = a[i][y];
            a[i][y] = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) 
        {
          s = new Scanner(System.in);
        }
        int n = s.nextInt();
        int x = s.nextInt();
        int y = s.nextInt();
        int[][] a = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = s.nextInt();
            }
        }

        a = swap(a, x - 1, y - 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        s.close();
    }
}
