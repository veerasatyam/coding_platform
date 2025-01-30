import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class M {

    public static int countDistinctNumbers(int[] A, int N) {
        Set<Integer> distinctNumbers = new HashSet<>();
        for (int i = 0; i < N; i++) {
            distinctNumbers.add(A[i]);
        }
        return distinctNumbers.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        int result = countDistinctNumbers(A, N);
        System.out.println(result);
    }
}
