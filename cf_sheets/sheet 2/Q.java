import java.util.Scanner;

public class Q {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        for (int i = 0; i < T; i++) {
            long N = s.nextLong(); 
            if (N == 0) { 
                System.out.println("0");
                continue;
            }
            long[] digits = new long[10];
            int count = 0;
            while (N != 0) {
                digits[count] = N % 10; 
                N = N / 10; 
                count++; 
            }
            for (int j = 0; j < count; j++) {
                System.out.print(digits[j]);
                if (j < count - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        s.close(); 
    }
}


// import java.util.Scanner;

// public class Q {
//     public static void main(String[] args) {
//         Scanner s = new Scanner(System.in);
//         int T = s.nextInt();

//         for (int i = 0; i < T; i++) {
//             long N = s.nextLong(); 
            
//             if (N == 0) { 
//                 System.out.println("0");
//                 continue;
//             }
            
//             StringBuilder output = new StringBuilder();
//             while (N != 0) {
//                 output.append(N % 10).append(" "); // Append digit and space
//                 N /= 10; // Divide by 10 to remove the last digit
//             }
            
//             // Print the result, removing the trailing space
//             System.out.println(output.toString().trim());
//         }

//         s.close(); 
//     }
// }

