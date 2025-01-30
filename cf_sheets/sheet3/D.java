import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner s=null;
        try {
            s= new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s=new Scanner(System.in);
        }
        int n=s.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=s.nextInt();
            if(a[i]<=10) System.out.println("A["+i+"] = "+a[i]);
        }
        s.close();

    }
}