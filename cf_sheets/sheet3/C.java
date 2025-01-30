import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class C {
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
            if(a[i]>0) a[i]=1;
            else if(a[i]<0) a[i]=2;
            else a[i]=0;
        }
        for(int x:a) System.out.print(x+" ");



    }
}
