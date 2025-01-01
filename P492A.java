import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P492A {
      public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in); 
        }
        int n = s.nextInt();
        int cubes =n;
        int i,sum=0;
        for(i=1;i<=n;i++)
        {
          sum +=i;
          cubes = cubes-sum;
          if(!(cubes>=0)) break;  
        }
        System.out.println(i-1);
        s.close();
    }
}
