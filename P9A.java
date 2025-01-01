import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P9A {
     public static void main(String[] args) {
        Scanner s = null;
        
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int y=s.nextInt();
        int W=s.nextInt();
        int max=Math.max(y, W);
        int dot_possibility=6-max+1;
        int i;
        for(i=6;i>=1;i--)
        {
            if(6%i==0 && dot_possibility%i==0 )
            {
                System.out.println(dot_possibility/i+"/"+6/i);
                break;
            }
        }
        s.close();
       
    }
}
