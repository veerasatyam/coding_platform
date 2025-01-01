import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1311A {
    public static void main(String[] args) {
        Scanner s = null;
        try{
            s=new Scanner(new File("input.txt"));
        }
        catch(FileNotFoundException e)
        {
            s = new Scanner(System.in);
        }
        int t = s.nextInt();
        while(t-->0)
        {
            int a = s.nextInt();
            int b = s.nextInt();
            int diff = b-a;
            int count=0;
            if(diff>0){
                if(diff%2!=0) count=1;
                else count=2;
            }
            else if(diff<0){
                if(diff%2==0) count =1;
                else count=2;
            }
            System.out.println(count);
        }
        s.close();
    }
}
