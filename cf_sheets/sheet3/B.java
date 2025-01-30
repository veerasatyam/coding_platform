import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner s = null;
        try{
            s=new Scanner(new File("input.txt"));
        }
        catch(FileNotFoundException e){
         s = new Scanner(System.in);
        }
        int n=s.nextInt();
        int[] a = new int[n];
        boolean b=true;
        for(int i=0;i<n;i++) a[i]=s.nextInt();
        int Target=s.nextInt();
        for(int i=0;i<n;i++)
        {
            if(a[i]==Target) 
            {
                b=false;
                System.out.println(i);
                break;
            }
        }
        if(b) System.out.println(-1);
        s.close();
    }
}
