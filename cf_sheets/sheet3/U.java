import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class U {
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
        int[] b = new int[M];
        int i,j=0;
        for(i=0;i<N;i++) a[i]=s.nextInt();
        for(i=0;i<M;i++) b[i]=s.nextInt();
        int a_index=0,b_index=0;
        while(a_index<a.length && b_index<b.length)
        {
            if(a[a_index]==b[b_index]) b_index++;
            a_index++;
        }
        if(b_index==b.length) System.out.println("YES");
        else System.out.println("NO");
        s.close();
    }
}
