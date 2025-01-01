import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class P1352A {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s=new Scanner(System.in);
        }
        int t = s.nextInt();
        while (t-- > 0) {
            int x = s.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            int place = 1; 
            int count=0;
            while (x != 0) {
                int digit = x % 10; 
                if(digit!=0) 
                {
                    count++;
                    list.add(digit * place);
                }
                x -= digit;
                x /= 10; 
                place *= 10;
            }
         System.out.println(count);
            for (int num : list) 
            {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        s.close();
    }
}
