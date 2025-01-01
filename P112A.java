import java.util.Scanner;
// submitted
public class P112A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        
        String firstString = s.nextLine().trim().toLowerCase();
        String secondString = s.nextLine().trim().toLowerCase();
        if (firstString.compareTo(secondString) == 0) {
            System.out.println(0);
        } else if (firstString.compareTo(secondString) > 0) {
            System.out.println(1);
        } else {
            System.out.println(-1);
        }
        
        s.close();
    }
}
