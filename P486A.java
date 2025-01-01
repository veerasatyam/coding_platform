import java.util.Scanner;
//submitted
public class P486A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N=s.nextInt();
        int EN,ON;
        int function_value;
        if(N%2==0)
        {
            EN=N/2;
            ON=N/2;
        }
        else{
            EN=N/2;
            ON=(N/2)+1;
        }
     function_value=EN*(EN+1)-(ON*ON);
     System.out.println(function_value);
    }
}

// import java.util.Scanner;

// public class P486A {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         long n = scanner.nextLong();  // Using long to handle large values up to 10^15
//         long result;

//         if (n % 2 == 0) {
//             result = n / 2;
//         } else {
//             result = -(n + 1) / 2;
//         }

//         System.out.println(result);
//     }
// }

