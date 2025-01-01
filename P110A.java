import java.util.Scanner;

//submitted

public class P110A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String N = s.nextLine();
        
        int luckyCount = 0;
        
        // Count lucky digits (4 and 7)
        for (int i = 0; i < N.length(); i++) {
            char n = N.charAt(i); 
            if (n == '7' || n == '4') { 
                luckyCount++;
            }
        }
        
        // Check if luckyCount itself is a lucky number
        if (luckyCount==4 || luckyCount==7) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        
        s.close(); 
    }
}
    