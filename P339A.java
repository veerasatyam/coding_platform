import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class P339A {
    public static void main(String[] args)
    {
        Scanner s= null;
        try{
            s=new Scanner(new File("input.txt"));
        }
        catch(FileNotFoundException e)
        {
             s= new Scanner(System.in);
        }
        String str = s.nextLine();
        int[] a = new int[(str.length()/2)+1];
        int i,j=0;
        for(i=0;i<str.length();i++)
        {
            if(str.charAt(i)!='+')
            {
                a[j]=Integer.parseInt(String.valueOf(str.charAt(i)));
                j++;
            } 
        }
        Arrays.sort(a);
        j=0;
        for(i=0;i<str.length();i++)
        {
            if(i%2==0)
            {
                System.out.print(a[j]);
                j++;
            }
            else System.out.print("+");
        }
         s.close();
    }
}

// import java.io.File;
// import java.io.FileNotFoundException;
// import java.util.Arrays;
// import java.util.Scanner;

// public class P339A {
//     public static void main(String[] args) {
//         Scanner s = null;
//         try {
//             s = new Scanner(new File("input.txt"));
//         } catch (FileNotFoundException e) {
//             s = new Scanner(System.in);
//         }
        
//         // Read the input string
//         String str = s.nextLine();
        
//         // Split the string by the '+' sign to extract the numbers
//         String[] numbers = str.split("\\+");
        
//         // Convert the string array to an integer array
//         int[] a = new int[numbers.length];
//         for (int i = 0; i < numbers.length; i++) {
//             a[i] = Integer.parseInt(numbers[i]);
//         }
        
//         // Sort the array of numbers
//         Arrays.sort(a);
        
//         // Print the sorted numbers with '+' signs
//         for (int i = 0; i < a.length; i++) {
//             if (i > 0) {
//                 System.out.print("+");
//             }
//             System.out.print(a[i]);
//         }
        
//         s.close();
//     }
// }

