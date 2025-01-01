// public class Rough
// {
//     public static void main (String[] args)
//     {
//        String s = null;
//        try{
//         int i = s.length();
//        }
//        catch(NullPointerException e)
//        {
//         System.out.println(e);
//        }
//     }
// }


// // Step 1: Define a custom exception class
// class InvalidAgeException extends Exception {
//     public InvalidAgeException(String message) {
//         super(message);  // Pass the message to the Exception class
//     }
// }

// public class Main {
//     // Step 2: Method to check age and throw custom exception if invalid
//     public static void checkAge(int age) throws InvalidAgeException {
//         if (age < 18) {
//             throw new InvalidAgeException("Age must be at least 18");
//         }
//     }

//     public static void main(String[] args) {
//         int age = 15;  // Example age

//         try {
//             checkAge(age);  // Check if the age is valid
//             System.out.println("Age is valid: " + age);  // This won't run if age is invalid
//         } catch (InvalidAgeException e) {
//             System.out.println("Error: " + e.getMessage());  // Catch and print the exception message
//         }
//     }
// }


// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;

// public class FileCopyCharacterOriented {
//     public static void main(String[] args) {
//         // Specify the source and destination files
//         String sourceFile = "source.txt";  // Change this to the path of your source file
//         String destinationFile = "destination.txt";  // Change this to the path of your destination file
        
//         FileReader fr = null;
//         FileWriter fw = null;
        
//         try {
//             // Create FileReader to read from the source file
//             fr = new FileReader(sourceFile);  
//             // Create FileWriter to write to the destination file
//             fw = new FileWriter(destinationFile);  
            
//             // Create a buffer to read characters
//             char[] buffer = new char[1024];  // Buffer to hold the characters (you can adjust the size)
//             int charactersRead;
            
//             // Read characters from the source file and write to the destination file
//             while ((charactersRead = fr.read(buffer)) != -1) {
//                 fw.write(buffer, 0, charactersRead);  // Write the characters to the destination file
//             }

//             System.out.println("File copied successfully!");
//         } catch (IOException e) {
//             // Handle any I/O exceptions
//             e.printStackTrace();
//         } finally {
//             // Close the file readers and writers to release resources
//             try {
//                 if (fr != null) fr.close();
//                 if (fw != null) fw.close();
//             } catch (IOException e) {
//                 e.printStackTrace();
//             }
//         }
//     }
// }




// import java.io.File;
// import java.io.FileNotFoundException;
// import java.util.Scanner;

// public class P1462A {
//     public static void main(String[] args) {
//         Scanner s = null;
//         try{
//             s=new Scanner(new File("input.txt"));
//         }
//         catch(FileNotFoundException e)
//         {
//             s = new Scanner(System.in);
//         }
//         int t = s.nextInt();
//         while(t-->0)
//         {
//             int n = s.nextInt();
//             int[] a = new int[n];
//             int right=n-1,left=0,i;
//             for(i=0;i<n;i++){
//                 if(i%2==0){
//                     a[left]=s.nextInt();
//                     left++;
//                 }else{
//                     a[right]=s.nextInt();
//                     right--;
//                 }
//             }
//             for(int c : a) System.out.print(c+" ");
//             System.out.println();
//         }
//         s.close();
//     }
// }
import java.util.Scanner;

public class Rough {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int t = s.nextInt(); // Number of test cases
       
        
        s.close();
    }
}
