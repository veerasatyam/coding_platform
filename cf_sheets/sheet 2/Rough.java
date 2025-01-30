import java.util.Scanner;

public class Rough{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int A = s.nextInt();
        int B = s.nextInt();
        boolean foundLucky = false;
        for (int i = A; i <= B; i++) {
            if (isLucky(i)) {
                System.out.print(i + " ");
                foundLucky = true;
            }
        }
        if (!foundLucky) {
            System.out.println("-1");
        }
        
        s.close();
    }
    public static boolean isLucky(int number) {
        String numStr = Integer.toString(number);
        for (char c : numStr.toCharArray()) {
            if (c != '4' && c != '7') {
                return false;
            }
        }
        return true;
    }
}
