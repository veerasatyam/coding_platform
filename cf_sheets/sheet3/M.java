import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class M {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)  a[i] = s.nextInt(); 
        int min_Index = 0, max_Index = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] < a[min_Index]) min_Index = i;
            if (a[i] > a[max_Index]) max_Index = i;
        }
        
        int temp = a[max_Index];
        a[max_Index] = a[min_Index];
        a[min_Index] = temp;
        
     
        for (int value : a)  System.out.print(value + " ");
            s.close();
        
    }
}
