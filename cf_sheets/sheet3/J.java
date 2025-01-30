import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class J {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int n=s.nextInt();
        int[] a = new int[n];
        int i,count=0;
        for(i=0;i<n;i++) a[i]=s.nextInt();
        Arrays.sort(a);
        int min=a[0];
        for(i=0;i<n;i++) if(a[i]==min) count++;
        if(count%2!=0) System.out.println("Lucky");
        else System.out.println("Unlucky");
    }
}
