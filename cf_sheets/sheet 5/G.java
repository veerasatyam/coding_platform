import java.util.Arrays;
import java.util.Scanner;

public class G {
    void maxmin(int[] a)
    {
       Arrays.sort(a);
       int min = a[0];
       int max = a[a.length-1];
       System.out.println(min+" "+max);
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=s.nextInt();
        }
        G g = new G();
        g.maxmin(a);
        s.close();

    }
}
