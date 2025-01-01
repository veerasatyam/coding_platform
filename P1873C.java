import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1873C {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }

        int t = s.nextInt();
        s.nextLine();
        
        while (t-- > 0) {
            String[] input = new String[10];
            for (int i = 0; i < 10; i++) {
                input[i] = s.nextLine();
            }

            int score = 0;

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (input[i].charAt(j) == 'X') {
                        if (i == 0 || i == 9 || j == 0 || j == 9) {
                            score += 1;
                        } else if (i == 1 || i == 8 || j == 1 || j == 8) {
                            score += 2;
                        } else if (i == 2 || i == 7 || j == 2 || j == 7) {
                            score += 3;
                        } else if (i == 3 || i == 6 || j == 3 || j == 6) {
                            score += 4;
                        } else if (i == 4 || i == 5 || j == 4 || j == 5) {
                            score += 5;
                        }
                    }
                }
            }
            System.out.println(score);
        }
        
        s.close();
    }
}
