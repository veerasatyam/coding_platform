
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P935A {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int n = s.nextInt();
        int ways = 0,i;
        for(i=1;i<n;i++) if(n%i==0) ways++;
        System.out.println(ways);
    }
}
