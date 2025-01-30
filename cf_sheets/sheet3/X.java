import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class X {
//doubt wyy 
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }

        int n = s.nextInt();
        int m = s.nextInt();
        s.nextLine();

        char[][] a = new char[n][m];
        int row = -1, column = -1;

        for (int i = 0; i < n; i++) {
            String line = s.nextLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = line.charAt(j);
                if (a[i][j] == '.') {
                    row = i;
                    column = j;
                }
            }
        }

        int X = s.nextInt();
        int Y = s.nextInt();

        if (X < 0 || X >= n || Y < 0 || Y >= m) {
            System.out.println("NO");
            return;
        }

        Set<Integer> validMoves = new HashSet<>();
        validMoves.add(0);
        validMoves.add(1);
        validMoves.add(-1);

        int rowDiff = X - row;
        int colDiff = Y - column;

        if (validMoves.contains(rowDiff) && validMoves.contains(colDiff)) System.out.println("no");
        else System.out.println("yes"); 
            s.close();
    }
}
