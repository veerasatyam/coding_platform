import java.util.Scanner;

public class O {

    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int getMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static boolean isPalindrome(int num) {
        int original = num, reverse = 0;
        while (num > 0) {
            reverse = reverse * 10 + num % 10;
            num /= 10;
        }
        return original == reverse;
    }

    public static int getMaxDivisors(int[] arr) {
        int maxDivisors = 0, numberWithMaxDivisors = arr[0];
        for (int num : arr) {
            int count = 0;
            for (int i = 1; i <= num; i++) {
                if (num % i == 0) {
                    count++;
                }
            }
            if (count > maxDivisors || (count == maxDivisors && num > numberWithMaxDivisors)) {
                maxDivisors = count;
                numberWithMaxDivisors = num;
            }
        }
        return numberWithMaxDivisors;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        
        int max = getMax(A);
        int min = getMin(A);
        
        int primeCount = 0;
        int palindromeCount = 0;
        for (int num : A) {
            if (isPrime(num)) primeCount++;
            if (isPalindrome(num)) palindromeCount++;
        }
        
        int maxDivisors = getMaxDivisors(A);
        
        System.out.println("The maximum number : " + max);
        System.out.println("The minimum number : " + min);
        System.out.println("The number of prime numbers : " + primeCount);
        System.out.println("The number of palindrome numbers : " + palindromeCount);
        System.out.println("The number that has the maximum number of divisors : " + maxDivisors);
    }
}
