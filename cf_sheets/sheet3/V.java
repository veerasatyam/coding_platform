import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class V {
    
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int N=s.nextInt();
        int M=s.nextInt();
        int[] a = new int[N];
        int i;
        for(i=0;i<N;i++) a[i]=s.nextInt();
        i=0;
        while(M-->0)
        {   
            int count=0;
            int x=a[i];
            for(int j=0;j<N;j++) if(a[j]==x) count++;
            System.out.println(count);
            i++;
        }
        s.close();
    }
}
