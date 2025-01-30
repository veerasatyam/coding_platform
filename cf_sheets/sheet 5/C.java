import java.util.Scanner;

public class C {
    public static boolean isOdd(int N) {
        return N % 2 != 0;
    }

    public static boolean isBinaryPalindrome(int N) {
        String binaryString = Integer.toBinaryString(N);
        String reversedBinary = new StringBuilder(binaryString).reverse().toString();
        return binaryString.equals(reversedBinary);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        if (isOdd(N) && isBinaryPalindrome(N)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        
        scanner.close();
    }
}
