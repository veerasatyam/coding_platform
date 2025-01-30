import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }

        int N = s.nextInt();
        boolean flag = true;

        if (N <= 1) {
            flag = false;
        } else if (N == 2) {
            flag = true;
        } else if (N % 2 == 0) {
            flag = false;
        } else {
            for (int i = 3; i * i <= N; i += 2) {
                if (N % i == 0) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        s.close();
    }
}
