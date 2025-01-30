import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Arrays;
// think again array sort avvatlee
public class J {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        String a = s.next();
        char[] charArray = a.toCharArray();
        Arrays.sort(charArray);
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            int count = 1;
            while (i + 1 < charArray.length && charArray[i] == charArray[i + 1]) {
                count++;
                i++;
            }
            map.put(charArray[i], count);
        }
        for (Character key : map.keySet()) System.out.println(key + " : " + map.get(key));
        s.close();
    }
}
