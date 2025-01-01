import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P630A {
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
        long n=s.nextLong();
        if(n==0) System.out.println("00");
        if(n==1) System.out.println("05");
        else System.out.println("25");
        s.close();
}
}
