import java.util.Arrays;
import java.util.Scanner;
public class P1760A {
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        int T=s.nextInt();
        for(int i=0;i<T;i++)
        {
         int[] num_arr= new int[3];
         for(int j=0;j<3;j++) num_arr[j]=s.nextInt();
           Arrays.sort(num_arr);
           System.out.println(num_arr[1]);
        }
        s.close();
    }
}
