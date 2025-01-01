import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1283A {
     public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }

        int t = s.nextInt();
        int total_min=1440;
        while(t-->0)
        {
            int minutes_left;
            int hours=s.nextInt();
            int minutes=s.nextInt();
            if(hours==0) 
            {
               minutes_left = total_min-minutes;
               System.out.println(minutes_left);
            }
            else{
                minutes_left = 1440-hours*60-minutes;
                System.out.println(minutes_left);
            }
        }
        s.close();
    }
  }
