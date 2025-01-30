import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
         Scanner  s= null;
        try {
           s = new Scanner(new File("input.txt")); 
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int A = s.nextInt();
        int B = s.nextInt();
        if (A > B) {
            int temp = A;
            A = B;
            B = temp;
        }
        long totalSum = 0;
        long evenSum = 0;
        long oddSum = 0;

       
        for (int i = A; i <= B; i++) {
            totalSum += i;            
            if (i % 2 == 0) {         
                evenSum += i;         
            } else {                 
                oddSum += i;         
            }
        }
        System.out.println(totalSum);
        System.out.println(evenSum);
        System.out.println(oddSum);
        
        s.close();
    }
}
