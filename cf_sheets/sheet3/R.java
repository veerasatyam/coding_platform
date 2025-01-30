import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class R {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);   
        }
        
        int n = s.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int sum_a=0,sum_b=0,i;
        for(i=0;i<n;i++)
        {
            a[i]=s.nextInt();
            sum_a +=a[i];
        }
        for(i=0;i<n;i++)
        {
            b[i]=s.nextInt();
            sum_b +=b[i];
        }
        if(sum_a==sum_b) System.out.println("yes");
        else System.out.println("no");
    }
}
