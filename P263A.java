import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P263A {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int[][] a = new int[6][6];
        int i,j,found_r=0,found_c=0;
        for(i=1;i<=5;i++)
        {
            for(j=1;j<=5;j++)
            {
                a[i][j]=s.nextInt();
                if(a[i][j]==1)
                {
                    found_c=j;
                    found_r=i;
                }
            }
        } 
        int operations;
        operations = Math.abs(3-found_r) + Math.abs(3-found_c);
        System.out.println(operations);
    }
}
