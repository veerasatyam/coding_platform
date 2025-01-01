import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P1607A {
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
            String keyboard = s.nextLine();
            Map<Character, Integer> position = new HashMap<>();

            for (int j = 0; j < 26; j++) {
                position.put(keyboard.charAt(j), j);
            }

            String word = s.nextLine();
            int totalTime = 0;
            int currentPosition = position.get(word.charAt(0));

            for (int j = 1; j < word.length(); j++) {
                int nextPosition = position.get(word.charAt(j));
                totalTime += Math.abs(nextPosition - currentPosition);
                currentPosition = nextPosition;
            }
            System.out.println(totalTime);
        }
    }
}
