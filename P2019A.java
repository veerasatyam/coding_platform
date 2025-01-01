import java.lang.*;
import java.util.Scanner;
// yet to submit
public class P2019A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt(); 

        for (int m = 0; m < t; m++) {
            int N = s.nextInt(); 
            int[] array = new int[N];

           
            for (int j = 0; j < N; j++) {
                array[j] = s.nextInt();
            }

    
            int max = array[0];
            for (int i = 1; i < N; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }

            
            int numberRedElements;
            if (N % 2 == 0) {
                numberRedElements = N / 2;
            } else {
                numberRedElements = N / 2 + 1;
            }

            
            System.out.println(numberRedElements + max);
        }

        s.close(); 
    }
}
