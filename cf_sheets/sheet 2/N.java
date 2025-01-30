import java.util.Scanner;

public class N {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String S = s.next();
        int N = s.nextInt();
        for (int i = 0; i < N; i++) {
            int X = s.nextInt();
            for (int j = 0; j < X; j++)  System.out.print(S);
            
            System.out.println();
        }
        
        s.close();
    }
}
