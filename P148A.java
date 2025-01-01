import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P148A {
     public static void main(String[] args)
    {
        Scanner s= null;
        try{
            s=new Scanner(new File("input.txt"));
        }
        catch(FileNotFoundException e)
        {
             s= new Scanner(System.in);
        }
        int[] a=new int[4];
        int i;
        for(i=0;i<4;i++) a[i]=s.nextInt();
        int d=s.nextInt();
        boolean[] dragon = new boolean[d+1];
        for(i=1;i<=d;i++)
        {
            if(i%a[0]==0) dragon[i]=true;
            if(i%a[1]==0) dragon[i]=true;
            if(i%a[2]==0) dragon[i]=true;
            if(i%a[3]==0) dragon[i]=true;
        }
        int count=0;
        for(i=1;i<=d;i++) if(dragon[i]) count++;
        System.out.println(count);
        s.close();

    }
}
