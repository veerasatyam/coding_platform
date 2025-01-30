import java.util.Scanner;

public class J {
    public static double calculateAverage(double[] arr, int n) {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        return sum / n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double[] A = new double[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextDouble();
        }
        double average = calculateAverage(A, N);
        System.out.printf("%.6f", average);
    }
}
