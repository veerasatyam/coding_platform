import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class P1154A {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) arr[i] = s.nextInt();
        Arrays.sort(arr);
        int sum = arr[3];
        int x1 = arr[0],x2 = arr[1],x3 = arr[2];   
        int a = sum - x3,b = sum - x2,c = sum - x1; 
        System.out.println(a + " " + b + " " + c);
        s.close();
    }
}
