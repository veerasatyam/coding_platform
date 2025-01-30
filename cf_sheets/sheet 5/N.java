import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class N{
    public static void shiftZerosToRight(int[] A, int N) {
        int nonZeroCount = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] != 0) {
                A[nonZeroCount++] = A[i];
            }
        }
        while (nonZeroCount < N) {
            A[nonZeroCount++] = 0;
        }
    }
    public static void main(String args[])
    {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) 
        {
          s = new Scanner(System.in);
        }
        int N = s.nextInt();
        int[] A = new int[N];
        for(int i=0;i<N;i++)
        {
            A[i]=s.nextInt();
        }
        shiftZerosToRight(A, N);
        for (int i = 0; i < N; i++) {
            System.out.print(A[i] + " ");
        }
    }
}