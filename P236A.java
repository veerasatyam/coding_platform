import java.util.Scanner;
// submitted

public class P236A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String username = s.nextLine();
        int distinctCount = 0;

        for (int i = 0; i < username.length(); i++) {
            char currentChar = username.charAt(i);
            boolean isDistinct = true;

            for (int j = 0; j < i; j++) {
                if (username.charAt(j) == currentChar) {
                    isDistinct = false; 
                    break;
                }
            }
            if (isDistinct) {
                distinctCount++;
            }
        }
        if (distinctCount % 2 == 0) {
            System.out.println("CHAT WITH HER!");
        } else {
            System.out.println("IGNORE HIM!");
        }
        
        s.close();
    }
}
