import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class P443A {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        String word = s.nextLine();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) if (Character.isLetter(word.charAt(i))) set.add(word.charAt(i));
        System.out.println(set.size());
    }
}
