import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class P1986A {
    public static void main(String[] args) {
          Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int t = s.nextInt();
        while(t-->0){
            int x1 = s.nextInt();
            int x2 = s.nextInt();
            int x3 = s.nextInt();
            int[] arr = {x1,x2,x3};
            Arrays.sort(arr);
            int a = arr[1];
            int result = Math.abs(a-x1) + Math.abs(a-x2)+Math.abs(a-x3);
            System.out.println(result);
        }
        s.close();
    }
}
