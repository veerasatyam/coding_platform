import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class K {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int n=s.nextInt();
        int[] a = new int[n];
        String num = s.next();
        int i,sum=0;
        for(i=0;i<n;i++)
        {
            a[i] = Character.getNumericValue(num.charAt(i));
            sum += a[i];
        } 
        System.out.println(sum);
        
    }
}
