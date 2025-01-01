import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1950C {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        
        int t = s.nextInt();
        s.nextLine();
        
        while(t-- > 0) {
            String time = s.nextLine();
            int hrs = Integer.parseInt(time.substring(0, 2));
            String min = time.substring(3);
            String period = "AM";
            
            if (hrs == 0) {
                period = "AM";
                hrs = 12;
            } else if (hrs >= 12) {
                if (hrs > 12) {
                    hrs = hrs - 12;
                }
                period = "PM";
            }
            
            if (hrs < 10) {
                System.out.println("0" + hrs + ":" + min + " " + period);
            } else {
                System.out.println(hrs + ":" + min + " " + period);
            }
        }
        
        s.close();
    }
}
