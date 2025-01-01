import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class P1999C {

    public static String canShower(int n, int s, int m, int[][] tasks) {
        if (tasks[0][0] >= s) {
            return "YES";
        }

        for (int i = 1; i < n; i++) {
            if (tasks[i][0] - tasks[i - 1][1] >= s) {
                return "YES";
            }
        }

        if (m - tasks[n - 1][1] >= s) {
            return "YES";
        }

        return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            sc = new Scanner(System.in);
        }
        int t = sc.nextInt();

        while(t-->0) {
            int n = sc.nextInt();
            int s = sc.nextInt();
            int m = sc.nextInt();

            int[][] tasks = new int[n][2];
            for (int j = 0; j < n; j++) {
                tasks[j][0] = sc.nextInt();
                tasks[j][1] = sc.nextInt();
            }

            System.out.println(canShower(n, s, m, tasks));
        }

        sc.close();
    }
}
