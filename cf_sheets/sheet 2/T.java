import java.util.Scanner;

public class T {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        
        for (int i = 0; i < N; i++) {
           
            for (int j = 0; j < N - i - 1; j++) {
                System.out.print(" ");
            }
          
            for (int m = 0; m < (2 * i + 1); m++) {
                System.out.print("*");
            }
            
            System.out.println();
        }
        
        s.close();
    }
}
