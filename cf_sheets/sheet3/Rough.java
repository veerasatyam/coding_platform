import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Rough {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int T = s.nextInt();
        
        // Process each test case
        for (int t = 0; t < T; t++) {
            // Size of the array
            int N = s.nextInt();
            int[] A = new int[N];
            
            // Reading the array elements
            for (int i = 0; i < N; i++) {
                A[i] = s.nextInt();
            }
            
            // Initialize the minimum value with a large number
            int minResult = Integer.MAX_VALUE;
            
            // Iterate over all possible pairs (i, j) where i < j
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    // Calculate Ai + Aj + j - i
                    int currentSum = A[i] + A[j] + (j - i);
                    // Update the minimum result
                    minResult = Math.min(minResult, currentSum);
                }
            }
            
            // Output the minimum result for the current test case
            System.out.println(minResult);
        }
        
        s.close();
    }
}
