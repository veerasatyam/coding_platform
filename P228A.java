import java.util.Scanner;

public class P228A{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] colors = new int[4];
        for (int i = 0; i < 4; i++)  colors[i] = s.nextInt();
        int uniqueCount = 0;
        for (int i = 0; i < 4; i++) {
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (colors[i] == colors[j]) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) uniqueCount++; 
        }
        System.out.println( 4 - uniqueCount);
        s.close();
    }
}
