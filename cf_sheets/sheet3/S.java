import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class S {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int n=s.nextInt();
        int m=s.nextInt();
        int[][] a = new int[n][m];
        int i,j;
        for(i=0;i<n;i++)  for(j=0;j<m;j++) a[i][j]=s.nextInt();
        int x=s.nextInt();
        boolean found = false;
        for(i=0;i<n;i++) for(j=0;j<m;j++)  if(a[i][j]==x) found=true;
       if(found) System.out.println("will not take number");
       else System.out.println("will take number");
    }
}
