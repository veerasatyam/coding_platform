import java.util.HashSet;
import java.util.Scanner;

public class P271A {
    public static void main(String[] args) {
        Scanner s = new java.util.Scanner(System.in);
        int y = s.nextInt();
        y++;
        while (true) {
            String yearStr = String.valueOf(y);
            HashSet<Character> set = new HashSet<>();
            for (char digit : yearStr.toCharArray()) set.add(digit);
            if (set.size() == 4) {
                System.out.println(y);
                break;
            }
            y++;
        }
        
        s.close();
    }
}
