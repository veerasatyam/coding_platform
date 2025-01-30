import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class T {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int n=s.nextInt();
        int[][] a = new int[n][n];
        int i,j,main_diagonal=0,secondary_diagonal=0;
        for(i=0;i<n;i++)  for(j=0;j<n;j++) a[i][j]=s.nextInt();
        for (i = 0; i < n; i++) {
            main_diagonal += a[i][i]; 
            secondary_diagonal += a[i][n- 1 - i]; 
        }
        System.out.println(Math.abs(main_diagonal-secondary_diagonal));
    }
}
