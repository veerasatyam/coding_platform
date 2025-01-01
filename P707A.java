import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class P707A {
     public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int n = s.nextInt();
        int m = s.nextInt();
        HashSet<Character> colours = new HashSet<>();
        colours.add('C');
        colours.add('M');
        colours.add('Y');
        char[][] a = new char[n][m];
        boolean b = false;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                a[i][j]=s.next().charAt(0);
                if(colours.contains(a[i][j])) b=true;
            } 
        }
        if(b) System.out.println("#Color");
        else System.out.println("#Black&White");
        s.close();
    }
}
