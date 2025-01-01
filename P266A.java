import java.util.Scanner;
//submitted
public class P266A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();// mandatory 
        String str = s.nextLine();
        
        char[] colors = new char[str.length()];

        for (int i = 0; i < str.length(); i++) 
        {
            colors[i] = str.charAt(i);
        }

        int count = 0;
        
        for (int m = 0; m < str.length() - 1; m++) {
            if (colors[m] == colors[m + 1]) 
            {
                count++;
            }
        }

        System.out.println(count);
        s.close();
    }
}



// import java.util.Scanner;

// public class P226A {
//     public static void main(String[] args) {
//         Scanner s = new Scanner(System.in);
//         int n = s.nextInt();
//         s.nextLine(); // Consume the newline character after the integer
        
//         String str = s.nextLine(); // Read the string of colors

//         int count = 0;

//         // Loop through the string and count consecutive same colors
//         for (int m = 0; m < str.length() - 1; m++) {
//             if (str.charAt(m) == str.charAt(m + 1)) {
//                 count++;
//             }
//         }

//         System.out.println(count);
//         s.close();
//     }
// }
