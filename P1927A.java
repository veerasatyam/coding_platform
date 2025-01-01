import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1927A {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int t = s.nextInt();
        while (t-->0) {
            int n = s.nextInt();
            String wb = s.next();
            char[] c = wb.toCharArray();
            int i,j;
            for(i=0;i<n;i++) if(c[i]=='B') break;
            for(j=n-1;j>=0;j--) if(c[j]=='B') break;
            System.out.println(j+1-i);
        }
        s.close();
    }
}
